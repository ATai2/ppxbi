package com.ppx.message.ppxusermgt.controller;

import com.ppx.message.ppxusermgt.dao.UserDao;
import com.ppx.message.ppxusermgt.entity.PpxUser;
import com.ppx.message.ppxusermgt.entity.CommonResp;
import com.ppx.message.ppxusermgt.entity.DemoModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequestMapping(value = "/user")
@RestController
@Api(value = "User")
public class UserController {

    @Autowired
    private UserDao userDao;

    @ApiOperation(value = "获取所有User")
    @GetMapping("/users")
    public CommonResp<List<PpxUser>> getUsers() {
        log.info("查询用户");
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

    @ApiOperation(value = "创建User")
    @PostMapping("/users")
    public CommonResp<String> createUser(@RequestBody List<PpxUser> users) {
        CommonResp<String> res = new CommonResp<>();
        userDao.saveAll(users);
        return res;
    }
    @ApiOperation(value = "test")
    @PostMapping("/demo2")
    public void demo2(@RequestBody @Valid DemoModel demo, BindingResult result){
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
    }
}
