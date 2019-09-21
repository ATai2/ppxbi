package com.ppx.pool;

import java.util.concurrent.TimeUnit;

public class WorkThread implements Runnable{
    private String name;
    public WorkThread(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is started.");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
