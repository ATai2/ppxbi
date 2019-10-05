//package com.ppx.learn.aop;
//
//import com.ppx.learn.dao.IndexDao;
//import com.ppx.learn.dao.IndexDaoImpl;
//import com.ppx.learn.dao.OrderDao;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Repository;
//
//import java.util.Arrays;
//
//@Repository
//@Slf4j
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Aspect("perthis(p())")
//public class OrderAspect {
//    @Autowired
//    OrderDao orderDao;
//
//    @DeclareParents(value = "com.ppx.learn.dao.*", defaultImpl = IndexDaoImpl.class)
//    public static IndexDao indexDao;
//
//    @Pointcut("execution(* com.ppx.learn.dao.*.*(..))")
//    public void p() {
//    }
//
//    @Before("p()")
//    public void before() {
//        log.info("order before");
//    }
//
//    @Pointcut("within(com.ppx.learn.dao.*)")
//    public void pointCutWithin() {
//
//    }
//
//    @Around("pointCutWithin()")
//    public void aroundWithin(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("around start");
//        Object[] args = joinPoint.getArgs();
//        log.info(Arrays.toString(args));
//        joinPoint.proceed(args);
//        log.info("around end");
//    }
//
//    @Pointcut("args(java.lang.String)")
//    public void pointCutArg() {
//
//    }
//}
