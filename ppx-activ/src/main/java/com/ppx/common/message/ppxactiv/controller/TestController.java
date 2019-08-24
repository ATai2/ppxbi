package com.ppx.common.message.ppxactiv.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String getTest(){
        return "hello";
    }
}
