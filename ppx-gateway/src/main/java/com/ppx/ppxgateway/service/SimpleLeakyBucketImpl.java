package com.ppx.ppxgateway.service;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单的漏桶算法实现
 */
public class SimpleLeakyBucketImpl<V> implements Bucket<V> {
    /**
     * 桶，用来盛放元素（请求）
     */
    private Object[] items;
    /**
     * 当前桶的请求的个数
     */
    private volatile int count = 0;

    /**
     * 间隔多少毫秒处理一个请求。（漏桶漏水的速度）
     */
    long interval;

    /**
     * 锁，用来锁定items
     */
    private ReentrantLock lock = new ReentrantLock();

    private int takeIndex = 0;
    private int putIndex = 0;

    private int receiveCount = 0;
    private int handleCount = 0;


    public SimpleLeakyBucketImpl(int capacity, long interval) {
        this.items = new Object[capacity];
        this.interval = interval;
        //开始漏水（处理请求）
        Thread t = new Thread(()->leak());
        t.start();
    }

    @Override
    public boolean receive(V item) {
        boolean isReceived = false;
        if (count < items.length) {
            lock.lock();
            //再次判断，可能在加锁之前，桶里变满了
            if (count < items.length) {
                isReceived = true;

                //放进桶里
                items[putIndex] = item;
                //修改索引
                putIndex = (putIndex + 1) % items.length;
                //个数加一
                count++;
                receiveCount++;
            }
            lock.unlock();

        }

        return isReceived;
    }


    /**
     * 循环处理请求，每隔interval毫秒，处理一个请求
     * 这里面的不足是：如果桶里面本来是空的，新来一个请求之后，线程可能无法立马处理，而是要sleep够一定的时间，才能进行处理。但是影响不大
     */
    private void leak() {
        try {
            while (true) {
                Thread.sleep(interval);

                //如果桶里面不空，就可以处理桶中的请求
                if (count > 0) {
                    lock.lock();

                    //再次判断，可能在加锁之前，桶里变空了
                    if (count > 0) {
                        V item = (V) items[takeIndex];
                        handle(item);

                        takeIndex = (takeIndex + 1) % items.length;

                        count--;
                    }

                    lock.unlock();
                } else {
                    //桶里面空了，什么都不做
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void handle(V item) {
        //处理请求
        System.out.println("正在处理请求：" + item);
        handleCount++;
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleLeakyBucketImpl<String> bucket = new SimpleLeakyBucketImpl<>(10, 100);
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 50; i++) {
            final int ii = i;
            Thread.sleep(r.nextInt(100));
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean isReceived = bucket.receive("请求" + ii);
                    if (isReceived) {
                        System.out.println("请求" + ii + "被接收");
                    } else {
                        System.out.println("请求" + ii + "被拒绝");
                    }
                }
            });
            t.start();

        }

        Thread.sleep(1000);
        System.out.println(bucket.handleCount);
        System.out.println(bucket.receiveCount);
    }
}
