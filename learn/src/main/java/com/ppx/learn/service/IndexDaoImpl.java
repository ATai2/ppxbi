package com.ppx.learn.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
@Lazy
public class IndexDaoImpl implements IndexDao, InitializingBean {


    public void init(){
        System.out.println("Init");
    }

    @PostConstruct
    public void post(){
        System.out.println("PostConstruct");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
