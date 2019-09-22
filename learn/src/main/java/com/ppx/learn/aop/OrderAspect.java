package com.ppx.learn.aop;

import com.ppx.learn.dao.IndexDao;
import com.ppx.learn.dao.IndexDaoImpl;
import com.ppx.learn.dao.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Aspect("perthis(p())")
public class OrderAspect {
    @Autowired
    OrderDao orderDao;

    @DeclareParents(value = "com.ppx.learn.dao.*", defaultImpl = IndexDaoImpl.class)
    public static IndexDao indexDao;

    @Pointcut("execution(* com.ppx.learn.dao.*.*(..))")
    public void p() {

    }

    @Before("p()")
    public void before(){
        log.info("order before");

    }

    @Pointcut("within(com.ppx.learn.dao.*)")
    public void pointCutWithin(){

    }
    @Pointcut("args(java.lang.String)")
    public void pointCutArg(){

    }
}
