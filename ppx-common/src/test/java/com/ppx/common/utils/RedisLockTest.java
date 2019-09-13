package com.ppx.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

@Slf4j
public class RedisLockTest {

    private RedissonClient redisson;

    @Before
    public void setUp(){
//        Redisson redisson=Redisson.create();
//单机
//        RedissonClient redisson = Redisson.create();
        Config config = new Config();
        config.useSingleServer().setAddress("redis://106.13.66.5:6379").setPassword("rootatai");
        redisson = Redisson.create(config);

//
////主从
//
//        Config config = new Config();
//        config.useMasterSlaveServers()
//                .setMasterAddress("127.0.0.1:6379")
//                .addSlaveAddress("127.0.0.1:6389", "127.0.0.1:6332", "127.0.0.1:6419")
//                .addSlaveAddress("127.0.0.1:6399");
//        RedissonClient redisson = Redisson.create(config);
//
//
////哨兵
//        Config config = new Config();
//        config.useSentinelServers()
//                .setMasterName("mymaster")
//                .addSentinelAddress("127.0.0.1:26389", "127.0.0.1:26379")
//                .addSentinelAddress("127.0.0.1:26319");
//        RedissonClient redisson = Redisson.create(config);
//
//
////集群
//        Config config = new Config();
//        config.useClusterServers()
//                .setScanInterval(2000) // cluster state scan interval in milliseconds
//                .addNodeAddress("127.0.0.1:7000", "127.0.0.1:7001")
//                .addNodeAddress("127.0.0.1:7002");
    }

    @Test
    public void lock() throws InterruptedException {
        RLock redloc = redisson.getLock("redloc");
        redloc.lock();
        log.info("test redlock");
        log.info(redloc.getName());
        Thread.sleep(20*1000);
        redloc.unlock();
    }
}