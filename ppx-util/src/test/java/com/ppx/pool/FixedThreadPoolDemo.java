package com.ppx.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool=Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            Runnable work=new WorkThread("tast"+i);
            pool.execute(work);
        }
        pool.shutdown();
    }
}
