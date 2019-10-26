package com.ppx.ppxusermgt.service;

import com.ppx.ppxusermgt.dao.UserDao;
import com.ppx.ppxusermgt.entity.PpxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    UserDao userDao;
    @Autowired
    RedisTemplate<String,String> cacheTemplate;

    public PpxUser insertUser(PpxUser user) {
        return userDao.save(user);
    }

    public void synchronizedSelectUserById(Integer id) {

    }
}
