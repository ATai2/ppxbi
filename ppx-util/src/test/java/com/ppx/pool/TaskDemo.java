package com.ppx.pool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TaskDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is running");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
