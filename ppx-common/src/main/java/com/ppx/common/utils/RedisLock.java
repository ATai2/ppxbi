package com.ppx.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RedisLock {
    RedisTemplate<String, String> redisTemplate;
    private String LOCK = "1";
    private Boolean lock = false;

    public RedisLock() {
    }

    public RedisLock(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void lock(String lockKey, long timeOut) {
//        1. setnx + 过期时间   防止死锁
        try {
            lock = redisTemplate.opsForValue().setIfAbsent(lockKey, LOCK);
            if (lock) {
                redisTemplate.expire(lockKey, timeOut, TimeUnit.SECONDS);

            } else {
                log.info("can't get key, do not excute task");
            }
        } finally {
            if (lock) {
                redisTemplate.delete(lockKey);
                log.info("task end, release lock");
            } else {
                log.info("can't get lock, no need to release lock.");
            }
        }
    }


}
