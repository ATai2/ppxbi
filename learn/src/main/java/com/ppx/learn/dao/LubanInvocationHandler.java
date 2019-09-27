package com.ppx.learn.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LubanInvocationHandler implements InvocationHandler {
    Object target;

    public LubanInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Luban proxy ");
        System.out.println(""+(proxy instanceof  LubanDao));
        System.out.println(method.getName());
        return method.invoke(target,args);
    }
}
