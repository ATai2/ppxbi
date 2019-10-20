package com.ppx.power.event;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyEventMainTest {
    @Autowired
    MyEventMain target;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void sendEvent() {
        target.sendEvent();
    }
}