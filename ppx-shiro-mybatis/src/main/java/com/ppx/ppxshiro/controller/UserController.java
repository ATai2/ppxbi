package com.ppx.ppxshiro.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/user")
    public String addUsers() {

        return "add user";
    }
}
