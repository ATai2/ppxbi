package com.ppx.ppxusermgt.controller;

import com.ppx.ppxusermgt.dao.UserDao;
import com.ppx.ppxusermgt.entity.CommonResp;
import com.ppx.ppxusermgt.entity.PpxUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user")
@RestController
@Api(value = "User")
public class UserController {

    @Autowired
    private UserDao userDao;

    @ApiOperation(value = "获取所有User")
    @GetMapping("/users")
    public CommonResp<List<PpxUser>> getUsers() {
        CommonResp<List<PpxUser>> res = new CommonResp<>();
        res.setData(userDao.findAll());
        return res;
    }

    @ApiOperation(value = "获取所有User")
    @GetMapping("/{name}")
    public CommonResp<PpxUser> getUser(@PathVariable String name) {
        CommonResp<PpxUser> res = new CommonResp<>();
        res.setData(userDao.findByUserName(name));
        return res;
    }

    @ApiOperation(value = "获取所有User")
    @PostMapping("/create")
    public CommonResp<String> createUser(@RequestBody PpxUser user) {
        CommonResp<String> res = new CommonResp<>();
        userDao.save(user);
        return res;
    }
}
