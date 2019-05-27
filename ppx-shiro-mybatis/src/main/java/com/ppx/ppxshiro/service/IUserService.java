package com.ppx.ppxshiro.service;

import com.ppx.ppxshiro.domain.User;

public interface IUserService {
    User findByName(String name);
}
