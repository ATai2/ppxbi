package com.ppx.ppxes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/helllo")
    public String hello(){
        return "Hello";
    }
}
