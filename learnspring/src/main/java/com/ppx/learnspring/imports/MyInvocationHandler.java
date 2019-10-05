package com.ppx.learnspring.imports;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    Object target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this is a proxy method");

        return method.invoke(target,args);
    }
}
