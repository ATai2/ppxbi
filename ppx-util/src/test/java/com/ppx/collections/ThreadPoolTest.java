package com.ppx.collections;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPoolTest {
    @Test
    public void cacheThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        Executor

//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                0,
//                10,
//                20,
//                TimeUnit.SECONDS,
//                new SynchronousQueue<Delayed>(), new ThreadPoolExecutor.AbortPolicy());
    }
}
