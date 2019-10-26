package com.ppx.ppxusermgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    RedisTemplate redisTemplate;

}
