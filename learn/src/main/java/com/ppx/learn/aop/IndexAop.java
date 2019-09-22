package com.ppx.learn.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Aspect
@Slf4j
@Component
public class IndexAop {

    @PostConstruct
    public void print(){
        System.out.println("==============================");
    }

//    @Pointcut("execution(public * com.ppx.learn.dao.IndexDaoImpl.test())")
    @Pointcut("execution(public * com.ppx.learn.service.*.*(..))")
    public void pointCout() {

    }

//    @Pointcut("within(com.ppx.learn.service.*)")
//    public void p2() {
//    }

    /**
     *
     * @param joinPoint
     */
    @Before(value = "pointCout()")
    public void before(JoinPoint joinPoint) {
        log.info("==========================before");
//        joinPoint.proceed();
        log.info("==========================beforebefore");

    }
    @Around(value = "pointCout()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("==========================around");
        joinPoint.proceed();
        log.info("==========================around end");

    }

//    @Before(value = "p2()")
//    public void before2() {
//        log.info("==========================before2");
//    }


}
