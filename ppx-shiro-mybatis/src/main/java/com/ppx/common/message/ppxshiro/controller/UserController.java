package com.ppx.common.message.ppxshiro.controller;

import com.ppx.common.message.ppxshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @功能描述：TODO
 * @创建日期: 2019/2/22 19:05
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "user/login";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model) {
        // 把数据存入model
        model.addAttribute("title", "SpringBoot与Shiro整合");
        // 返回test.html
        return "test";
    }

    @RequestMapping("/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "user/login";
    }

    @RequestMapping("/noAuth")
    public String noAuth(){
        return "noAuth";
    }
    /*
     *
     * @功能描述 使用Shiro认证
     * @创建日期 19:51 2019/2/22
     **/
    @RequestMapping("/login")
    public String login(String name,String password,boolean rememberMe, Model model) {

        //1、获取subject
        Subject subject = SecurityUtils.getSubject();

        //2、封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password,rememberMe);

        //3、执行登录方法
        try {
            //交给Realm处理--->执行它的认证方法
            subject.login(token);
            //登录成功
            return "redirect:/testThymeleaf";
        }catch (UnknownAccountException e){
            //登录失败:用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "user/login";
        }catch (IncorrectCredentialsException e){
            //登录失败：密码错误
            model.addAttribute("msg","密码错误");
            return "user/login";
        }
    }



}
