package com.ppx.px.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    public static final String INDEX = "index";
    @GetMapping("/")
    public String index(){
        return INDEX;
    }
}
