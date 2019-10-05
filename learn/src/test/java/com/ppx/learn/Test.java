package com.ppx.learn;

import com.ppx.learn.config.AppConfig;
import com.ppx.learn.dao.IndexDaoImpl;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Test {
    @org.junit.Test
    public void test(){
        ClassPathResource resource=new ClassPathResource("spring.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        Object bean = beanFactory.getBean("dao");
    }

    @org.junit.Test
    public void annoConfigTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        applicationContext.scan("com.ppx.learn.service");
        applicationContext.register(AppConfig.class);
        applicationContext.refresh();
        IndexDaoImpl bean = applicationContext.getBean(IndexDaoImpl.class);
        bean.test();
    }
}
