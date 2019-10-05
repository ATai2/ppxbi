//package com.ppx.learn.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//
//@Aspect
//@Slf4j
//@Component
//public class HttpAspect {
//    private static final MyThreadLocal<Long> time=new MyThreadLocal<Long>(){
//        @Override
//        protected Long initialValue() {
//            return System.nanoTime();
//        }
//    };
//
//    @Pointcut(value = "execution(public * com.ppx.learn.controller.*.*(..))")
//    public void p(){}
//
//    @Before("p()")
//    public void doBefore(JoinPoint joinPoint){
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        //URL
//        log.warn("URL={}",request.getRequestURL());
//
//        //Method
//        log.warn("Method={}",request.getMethod());
//
//        //IP
//        log.warn("IP={}",request.getRemoteAddr());
//
//        //Class.Method
//        log.warn("CLass.Method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+"()");
//
//        //Args
//        log.warn("Args={}",joinPoint.getArgs());
//
//        //...其余操作
//        time.get();
//    }
//
//    @After("p()")
//    public void doAfter(){
//        log.warn("HttpAspect doAfter Running : "+new Date().getTime());
//        log.warn("HttpAspect doAfter Running : "+(System.nanoTime()-time.get2())/1000000+"ms");
//    }
//
//    static class MyThreadLocal<T> extends ThreadLocal<T> {
//        @Override
//        public T get() {
//            remove();
//            return super.get();
//        }
//
//        public T get2() {
//            return super.get();
//        }
//    }
//
//}
