package com.ppx.ppxactiviti.controller;

import com.ppx.ppxactiviti.PpxActivitiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PpxActivitiApplication.class})
public class TestControllerTest {
    @Autowired
    Environment env;
    @Test
    public void testEnv(){
        System.out.println(env.getProperty("debug"));
        assertEquals(env.getProperty("debug"),"true");
    }
}