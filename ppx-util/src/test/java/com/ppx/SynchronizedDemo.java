package com.ppx;

import org.junit.Test;

public class SynchronizedDemo extends Thread {
    int index = 0;
    int SIZE = 500;

    @Override
    public void run() {
        for (int i = 0; i < SIZE; i++) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            index++;
            System.out.println(Thread.currentThread().getName()+"   " + index);
        }
        System.out.println(Thread.currentThread().getName()+"   " + "end");

    }

    @Test
    public void thes() throws InterruptedException {
        SynchronizedDemo demo = new SynchronizedDemo();
        SynchronizedDemo demo1 = new SynchronizedDemo();
        SynchronizedDemo demo2 = new SynchronizedDemo();
        SynchronizedDemo demo3 = new SynchronizedDemo();
        demo.start();
        demo1.start();
        demo2.start();
        demo3.start();
        demo.join();
        demo1.join();
        demo2.join();
        demo3.join();
    }

}
