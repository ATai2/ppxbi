package com.ppx.message.ppxshiro.dao;

import com.ppx.message.ppxshiro.entity.User;

public interface UserRepository extends BaseRepository<User,Long>{
    User findByName(String name);
}