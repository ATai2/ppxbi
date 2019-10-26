package com.ppx.ppxusermgt.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    ValueOperations<String, Object> valueOperations;

    @Test
    public void insertUser() {
        valueOperations.set("1","1");
        System.out.println(valueOperations.get("1"));
    }

    @Test
    public void synchronizedSelectUserById() {
    }
}