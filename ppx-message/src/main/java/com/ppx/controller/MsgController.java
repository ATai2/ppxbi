package com.ppx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {
    @RequestMapping("/msg")
    public String showMsg(){
        return "lsdjf";
    }
}
