package com.ppx.ppxshiro.service;

import com.ppx.ppxshiro.bean.UserBean;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserBean addUser(){
        System.out.println("add user");
        return new UserBean();
    }
}
