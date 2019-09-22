package com.ppx.learn.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
@Aspect

@Slf4j
public class IndexAop {

    @PostConstruct
    public void print(){
        System.out.println("==============================");
    }

    @Pointcut("execution(public * com.ppx.learn.service.IndexDaoImpl.test())")
    public void pointCout() {

    }

    @Pointcut("within(com.ppx.learn.service.*)")
    public void p2() {
    }

    @Before(value = "pointCout()")
    public void before() {
        log.info("==========================before");
    }

    @Before(value = "p2()")
    public void before2() {
        log.info("==========================before2");
    }


}
