package com.ppx.common.ppxutil.demos.velocitydemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenericDemoTest {

    @Test
    public void test1() {
        GenericDemo<String> bean=new GenericDemo<>();
        bean.test("sss");
    }

    @Test
    public void testMethod() {
        GenericDemo<String> bean=new GenericDemo<>();
        bean.testMethod(44);
    }
}