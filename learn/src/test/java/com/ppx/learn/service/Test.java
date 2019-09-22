package com.ppx.learn.service;

import com.ppx.learn.config.AppConfig;
import com.ppx.learn.dao.IndexDao;
import com.ppx.learn.dao.IndexDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    @org.junit.Test
    public   void main( ) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
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
