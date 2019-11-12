package com.ppx.ppxusermgt.controller;

import com.ppx.ppxusermgt.entity.CommonResp;
import com.ppx.ppxusermgt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/userbyid")
    public CommonResp<Object> getUserbyid(long id) {
        return userService.synchronizedSelectUserById(id);
    }
}
