package com.ppx.learn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexDaoImplTest {

    @Test
    public void test(){
        IndexDaoImpl dao=new IndexDaoImpl();
        dao.test();
    }
}