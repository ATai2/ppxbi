package com.ppx.learn.service;

import com.ppx.learn.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexDaoImpl bean = applicationContext.getBean(IndexDaoImpl.class);
        bean.test();
    }
}
