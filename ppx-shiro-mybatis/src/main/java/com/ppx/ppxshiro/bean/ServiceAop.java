package com.ppx.ppxshiro.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAop {

    @Pointcut("execution(* com.ppx.ppxshiro.service.*.*(..))") //声明一个切点
    public void checkUser(){
    }

    @Before("checkUser()")  //在方法执行前切入
    public void beforeCheck(){
        System.out.println("前置方法:我在方法前面");
    }

    @After("checkUser()")   //在方法执行后切入
    public void after() {
        System.out.println("后置通知:方法正常结束了");
    }

    @Around("checkUser()")  //环绕整个方法的前后
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入方法前---环绕通知");
        Object o = pjp.proceed();
        System.out.println("退出方法后---环绕通知");
        return o;
    }

}
