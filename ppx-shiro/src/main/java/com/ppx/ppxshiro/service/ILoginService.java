package com.ppx.ppxshiro.service;

import com.ppx.ppxshiro.entity.Role;
import com.ppx.ppxshiro.entity.User;

import java.util.Map;

public interface ILoginService {
    User addUser(Map<String, Object> map);

    Role addRole(Map<String, Object> map);

    User findByName(String name);
}
