package com.ppx.ppxshiro.controller;


import com.ppx.ppxshiro.PpxShiroApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PpxShiroApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class UTtest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void addUser(){

        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("username","lake");
        String result = testRestTemplate.postForObject("/user",multiValueMap,String.class);
        int i=0;
//        Assert.assertEquals(result.getCode(),0);
    }
}
