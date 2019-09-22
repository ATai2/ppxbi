package com.ppx.learn.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class IndexAop {

    @Pointcut("execution(* com.ppx.learn.service.IndexDaoImpl.test())")
    public void pointCout(){

    }

    @Before("pointCout()")
    public void before(){
        System.out.println("==========================before");
    }

}
