package com.ppx.common.utils;

import org.junit.Test;

public class SnowflakeIdWorkerTest {

    @Test
    public void test() {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        for (int i = 0; i < 1000; i++) {
            long id = idWorker.nextId();
            System.out.println(Long.toBinaryString(id));
            System.out.println(id);
        }
    }
}