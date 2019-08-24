package com.ppx.common.message.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {
    @RequestMapping("/msg")
    public String showMsg(){
        return "lsdjf";
    }
}
