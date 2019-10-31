package com.ppx.common.ppxutil.demos.velocitydemo;

public class GenericDemo<T> {
    public void test(T t) {
        System.out.println(t.getClass());
    }

    public <T> void testMethod(T t) {
        System.out.println(t.getClass());
    }
}
