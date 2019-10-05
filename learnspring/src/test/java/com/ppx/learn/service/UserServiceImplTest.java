package com.ppx.learn.service;

import com.ppx.learnspring.util.BeanFactory;
import org.junit.Test;

public class UserServiceImplTest {

    @Test
    public void find() {
        BeanFactory beanFactory = new BeanFactory("spring.xml");
        Object userService = beanFactory.getBean("service");

    }
}