package com.ppx.ppxusermgt.controller;

import com.ppx.ppxusermgt.dao.UserDao;
import com.ppx.ppxusermgt.entity.CommonResp;
import com.ppx.ppxusermgt.entity.PpxUser;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;
    @GetMapping("/users")
    public CommonResp<List<PpxUser>> getUsers(){
        CommonResp<List<PpxUser>> res=new CommonResp<>();
        res.setData(userDao.findAll());
        return res;
    }

    @GetMapping("/{name}")
    public CommonResp<PpxUser> getUser(@PathVariable String name) {
        CommonResp<PpxUser> res=new CommonResp<>();
        res.setData(userDao.findByUserName(name));
        return res;
    }

    @PostMapping("/create")
    public CommonResp<String> createUser(@RequestBody PpxUser user) {
        CommonResp<String> res=new CommonResp<>();
        userDao.save(user);
        return res;
    }
}
