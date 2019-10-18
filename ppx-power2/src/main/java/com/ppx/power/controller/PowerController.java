package com.ppx.power.controller;

import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "power")
@RestController
public class PowerController {

    @GetMapping("/power")
    public Object getPower() {
        SecurityProperties.User user=new SecurityProperties.User();
        user.setName("sss");
        return user;
    }
}
