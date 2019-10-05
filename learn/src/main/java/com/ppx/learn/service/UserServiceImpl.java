package com.ppx.learn.service;


import com.ppx.learn.dao.UserDao;

public class UserServiceImpl implements UserService {

    UserDao dao;

    @Override
    public void find() {
        System.out.println("service");
        dao.query();
    }

    //public void setDao(UserDao dao) {
       // this.dao = dao;
   // }
}
