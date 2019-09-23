package com.ppx.learn.aop;

import com.ppx.learn.dao.IndexDao;
import com.ppx.learn.dao.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderAspectTest implements ApplicationContextAware {
    @Autowired
    OrderDao orderDao;
    private ApplicationContext applicationContext;

    @Test
    public void p() {
    }

    @Test
    public void before() {
        IndexDao indexDao= (IndexDao) orderDao;
        indexDao.test();
        System.out.println(orderDao);
        OrderDao bean = applicationContext.getBean(OrderDao.class);
        System.out.println(bean);
        OrderDao bean1 = applicationContext.getBean(OrderDao.class);
        System.out.println(bean1);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testSpeak(){

    }
}