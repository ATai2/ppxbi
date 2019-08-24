package com.ppx.ppxshiro.dao;

import com.ppx.ppxshiro.entity.User;

public interface UserRepository extends BaseRepository<User,Long>{
    User findByName(String name);
}