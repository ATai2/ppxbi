package com.ppx.ppxshiro.mapper;

import com.ppx.ppxshiro.domain.User;

public interface UserMapper {
    User findByName(String name);
}
