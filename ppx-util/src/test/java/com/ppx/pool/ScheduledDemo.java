package com.ppx.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduledDemo {

    public static void main(String[] args) {
        ScheduledExecutorService pool=Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable task=new TaskDemo();
            //把任务交给pool去执行
            pool.execute(task);
        }
    }
}
