package com.ppx;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

@Slf4j
public class DelayedQueueTest {
    @Test
    public void test() {
        TaskQueueDaemonThread taskQueueDaemonThread = new TaskQueueDaemonThread();
        taskQueueDaemonThread.init();
        Random random = new Random(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            int time = random.nextInt(10);
            taskQueueDaemonThread.put(time, new Runnable() {
                @Override
                public void run() {
                    log.info("  runnable" + finalI);
                }
            });
        }

    }

    @Test
    public void testInterrupte() throws InterruptedException {

        Thread thread = new Thread(new InterruptedRunnable());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    static class TaskQueueDaemonThread {

        private static final Logger LOG = Logger.getLogger(TaskQueueDaemonThread.class.getName());

        private TaskQueueDaemonThread() {
        }

        private static class LazyHolder {
            private static TaskQueueDaemonThread taskQueueDaemonThread = new TaskQueueDaemonThread();
        }

        public static TaskQueueDaemonThread getInstance() {
            return LazyHolder.taskQueueDaemonThread;
        }

        Executor executor = Executors.newFixedThreadPool(20);
        /**
         * 守护线程
         */
        private Thread daemonThread;

        /**
         * 初始化守护线程
         */
        public void init() {
            daemonThread = new Thread(() -> execute());
            daemonThread.setDaemon(true);
            daemonThread.setName("Task Queue Daemon Thread");
            daemonThread.start();
        }

        private void execute() {
            System.out.println("start:" + System.currentTimeMillis());
            while (true) {
                try {
                    //从延迟队列中取值,如果没有对象过期则队列一直等待，
                    Task t1 = t.take();
                    if (t1 != null) {
                        //修改问题的状态
                        Runnable task = t1.getTask();
                        if (task == null) {
                            continue;
                        }
                        executor.execute(task);
                        LOG.info("[at task:" + task + "]   [Time:" + System.currentTimeMillis() + "]");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        /**
         * 创建一个最初为空的新 DelayQueue
         */
        private DelayQueue<Task> t = new DelayQueue<>();

        /**
         * 添加任务，
         * time 延迟时间
         * task 任务
         * 用户为问题设置延迟时间
         */
        public void put(long time, Runnable task) {
            //转换成ns
            long nanoTime = TimeUnit.NANOSECONDS.convert(time, TimeUnit.MILLISECONDS);
            //创建一个任务
            Task k = new Task(nanoTime, task);
            //将任务放在延迟的队列中
            t.put(k);
        }

        /**
         * 结束订单
         *
         * @param task
         */
        public boolean endTask(Task<Runnable> task) {
            return t.remove(task);
        }
    }

    public static class Task<T extends Runnable> implements Delayed {
        /**
         * 到期时间
         */
        private final long time;

        /**
         * 问题对象
         */
        private final T task;
        private static final AtomicLong atomic = new AtomicLong(0);

        private final long n;

        public Task(long timeout, T t) {
            this.time = System.nanoTime() + timeout;
            this.task = t;
            this.n = atomic.getAndIncrement();
        }

        /**
         * 返回与此对象相关的剩余延迟时间，以给定的时间单位表示
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.time - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            // TODO Auto-generated method stub
            if (other == this) // compare zero ONLY if same object
                return 0;
            if (other instanceof Task) {
                Task x = (Task) other;
                long diff = time - x.time;
                if (diff < 0)
                    return -1;
                else if (diff > 0)
                    return 1;
                else if (n < x.n)
                    return -1;
                else
                    return 1;
            }
            long d = (getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS));
            return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
        }

        public T getTask() {
            return this.task;
        }

        @Override
        public int hashCode() {
            return task.hashCode();
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof Task) {
                return object.hashCode() == hashCode() ? true : false;
            }
            return false;
        }


    }


    static class InterruptedRunnable implements Runnable {
        Logger logger = Logger.getLogger(InterruptedRunnable.class.getName());
        ReentrantLock reentrantLock = new ReentrantLock();

        @Override
        public void run() {
            try {
                reentrantLock.lock();
//                reentrantLock.lockInterruptibly();
                Thread.sleep(90000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("    inter      "+Thread.currentThread().getName());
        }
    }
}
