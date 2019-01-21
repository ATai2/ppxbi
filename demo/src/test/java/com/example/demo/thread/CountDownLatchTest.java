package com.example.demo.thread;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CountDownLatchTest {

    static CountDownLatch countDownLatch=new CountDownLatch(2);
static CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
    @Test
    public void testJoin() throws InterruptedException {
        Thread parse1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" runner1  ");
            }
        });
        Thread parse2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" runner2  ");
            }
        });
        parse1.start();
        parse2.start();
        parse1.join();
        parse2.join();
        System.out.println("all parser finish");
    }

    @Test
    public void testCountDown() throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            countDownLatch.countDown();
            System.out.println(2);
            countDownLatch.countDown();
            System.out.println(3);
//            try {
//                Thread.sleep(2000);
                System.out.println(33);
//                Thread.currentThread().sl
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }).start();
//        类似join
        countDownLatch.await();
        System.out.println(4);
    }

    @Test
    public void testCycleBarrier(){
        new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
