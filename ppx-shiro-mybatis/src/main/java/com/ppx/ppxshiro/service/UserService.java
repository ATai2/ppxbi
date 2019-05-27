package com.ppx.ppxshiro.service;

import com.ppx.ppxshiro.bean.UserBean;
import com.ppx.ppxshiro.domain.User;
import com.ppx.ppxshiro.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    public UserBean addUser(){
        System.out.println("add user");
        return new UserBean();
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }
}
