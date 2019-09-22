package com.ppx.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedPool {

    public static void main2(String[] args) {
        ExecutorService pool=Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
                //创建任务
                Runnable task=new TaskDemo();
                //把任务交给pool去执行
                pool.execute(task);
        }

    }
}
