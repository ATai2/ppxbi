package com.ppx.aqs;

import java.util.concurrent.atomic.AtomicInteger;

public class AQS1 {
    private static volatile int m=0;
    private static AtomicInteger n=new AtomicInteger(0);
    private static int size=800000;

    public static void increase(){
        m++;
    }
    public static void increaseAtomic(){
        n.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads=new Thread[size];
        Thread[] threadsA=new Thread[size];
        for (int i = 0; i < size; i++) {
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    increase();
                }
            });
            threads[i].start();
            threads[i].join();
        }
        System.out.println(""+m);

        for (int i = 0; i < size; i++) {
            threadsA[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    increaseAtomic();
                }
            });
            threadsA[i].start();
            threadsA[i].join();
        }
        System.out.println(n.get());


    }
}
