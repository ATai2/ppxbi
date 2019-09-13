package com.ppx.ppxgateway.service;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 令牌桶算法实现
 */
public class TokenBucketImpl<V> implements Bucket<V> {
    /**
     * 桶，存放令牌(其实不需要这个桶，可以想象有一个桶，只需要记录桶的容量capacity和当前桶中令牌的个数count就可以了，比较这两个值就可以知道能不能处理请求)
     */
    private byte[] items;

    /**
     * 当前桶中令牌的个数
     */
    private int count;

    /**
     * 令牌通放入一个令牌的间隔时间，单位：毫秒
     */
    private long interval;

    /**
     * 取出令牌的下标
     */
    private int takeIndex = 0;
    /**
     * 放入令牌的下标
     */
    private int putIndex = 0;

    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();


    public TokenBucketImpl(int capacity, long interval) {
        items = new byte[capacity];
        this.interval = interval;
        Thread t = new Thread(()->putTokenToBucket());
        t.start();
    }

    @Override
    public boolean receive(V item) {

        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (count == 0) {
                //令牌通中没有令牌了，直接拒绝
                return false;
            }

            byte token = items[takeIndex];
            takeIndex = (takeIndex + 1) % items.length;

            count--;
            notFull.signal();

            handle(item);

            return true;
        } finally {
            lock.unlock();
        }

    }

    private void handle(V item) {
        System.out.println("处理" + item);
    }

    /**
     * 每隔一段时间就往桶中放入令牌
     */
    private void putTokenToBucket() {
        try {
            while (true) {
                Thread.sleep(interval);

                lock.lock();

                try {
                    while (count == items.length) {
                        //如果当前桶是满的，则阻塞，进行等待
                        notFull.await();
                    }
                    //桶中有空闲位置了，放入令牌
                    //假设1表示令牌
                    items[putIndex] = 1;
                    putIndex = (putIndex + 1) % items.length;

                    count++;
                } finally {
                    lock.unlock();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Bucket<String> tokenBucket = new TokenBucketImpl<>(10, 100);
        Thread.sleep(1000);
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 50; i++) {
            final int ii = i;
            Thread.sleep(r.nextInt(100));
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean isReceived = tokenBucket.receive("请求" + ii);
                    if (isReceived) {
                        System.out.println("请求" + ii + "被接收");
                    } else {
                        System.out.println("请求" + ii + "被拒绝");
                    }
                }
            });
            t.start();

        }
    }
}
