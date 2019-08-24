package com.ppx.message.ppxshiro.service;

import com.ppx.message.ppxshiro.entity.Role;
import com.ppx.message.ppxshiro.entity.User;

import java.util.Map;

public interface ILoginService {
    User addUser(Map<String, Object> map);

    Role addRole(Map<String, Object> map);

    User findByName(String name);
}
