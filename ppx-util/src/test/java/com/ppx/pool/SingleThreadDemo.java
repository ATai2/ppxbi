package com.ppx.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadDemo {
    public static void main(String[] args) {
        ExecutorService pool=Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            //创建任务
            Runnable task=new TaskDemo();
            //把任务交给pool去执行
            pool.execute(task);
        }
    }
}
