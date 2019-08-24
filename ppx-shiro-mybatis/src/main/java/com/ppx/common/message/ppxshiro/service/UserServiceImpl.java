package com.ppx.common.message.ppxshiro.service;

import com.ppx.common.message.ppxshiro.dao.UserMapper;
import com.ppx.common.message.ppxshiro.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @功能描述：TODO
 * @创建日期: 2019/2/22 20:28
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
