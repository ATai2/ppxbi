package com.ppx.learn.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
@Slf4j
public class IndexDaoImpl implements IndexDao  {
//public class IndexDaoImpl implements IndexDao, InitializingBean {


//    public void init(){
//        System.out.println("Init");
//    }

    @PostConstruct
    public void post(){
        System.out.println("PostConstruct");
    }
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("afterPropertiesSet");
//    }

    public void test(){
        log.info("test");
    }

    public void speak(String msg){
        log.info(msg);

    }

}
