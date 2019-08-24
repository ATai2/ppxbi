package com.ppx.common.message.ppxshiro.dao;

import com.ppx.common.message.ppxshiro.entity.User;

public interface UserRepository extends BaseRepository<User,Long>{
    User findByName(String name);
}