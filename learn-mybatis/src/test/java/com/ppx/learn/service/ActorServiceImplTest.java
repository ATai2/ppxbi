package com.ppx.learn.service;

import com.ppx.learn.config.AppConfig;
import com.ppx.learn.dao.ActorMapper;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ActorServiceImplTest {

    @Test
    public void getActor() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ActorMapper bean = applicationContext.getBean(ActorMapper.class);
        System.out.println(bean.getActor(2));
//        ActorServiceImpl bean = applicationContext.getBean(ActorServiceImpl.class);
//        ActorEntity actor = bean.getActor(2);
//        System.out.println(actor.toString());
    }
}