package com.ppx.learn.service;

import com.ppx.learnspring.config.AppConfig;
import com.ppx.learnspring.dao.IndexDao;
import com.ppx.learnspring.dao.IndexDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    @org.junit.Test
    public   void main( ) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        applicationContext.register(AppConfig.class);
        applicationContext.scan("com");
//        applicationContext.refresh();
        IndexDaoImpl bean = applicationContext.getBean(IndexDaoImpl.class);
        bean.test();
    }
    @org.junit.Test
    public void test() throws IOException {
        Class<?>[] interfaces=new Class[]{IndexDao.class};
        byte[] aas = ProxyGenerator.generateProxyClass("aa", interfaces);
        File file=new File("D:\\Test.class");
        FileOutputStream fileWriter= new FileOutputStream(file);
        fileWriter.write(aas);
        fileWriter.flush();
        fileWriter.close();

    }
}
