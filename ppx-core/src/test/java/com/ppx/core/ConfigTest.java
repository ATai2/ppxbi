package com.ppx.core;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ConfigTest {

    private Config config;

    @Before
    public void setUp() throws Exception {
        config = new Config();
    }

    @Test
    public void save() {
        config.save("timeout","100");
        for (int i = 0; i <100; i++) {
            System.out.println(config.get("timeout"));

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void get() {
    }
}