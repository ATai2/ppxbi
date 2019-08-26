package com.ppx.px.controller;


import com.ppx.common.base.ResponseBase;
import com.ppx.common.constants.Constants;
import com.ppx.common.entity.UserEntity;
import com.ppx.px.service.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RegisterController {
    @Autowired
    private MemberServiceFeign memberServiceFegin;
    //	@Autowired
//	private ProjectUrlConfig projectUrlConfig;
    private static final String REGISTER = "register";
    private static final String LOGIN = "login";

    // 跳转注册页面
    @GetMapping(value = "/register" )
    public ModelAndView registerGet() {
        return new ModelAndView("register");
    }

    // 注册业务具体实现
    @PostMapping(value = "/register" )
    public String registerPost(UserEntity userEntity, HttpServletRequest reqest) {
        // 1. 验证参数
        // 2. 调用会员注册接口
        ResponseBase regUser = memberServiceFegin.regUser(userEntity);
        // 3. 如果失败，跳转到失败页面
        if (!regUser.getRtnCode().equals(Constants.HTTP_RES_CODE_200)) {
            reqest.setAttribute("error", "注册失败");
            return REGISTER;
//			 return new ModelAndView("register");
        }
        // 4. 如果成功,跳转到成功页面
        return LOGIN;
//		return new ModelAndView("redirect:" +projectUrlConfig.getSell() +"/sell/login");
    }
}
