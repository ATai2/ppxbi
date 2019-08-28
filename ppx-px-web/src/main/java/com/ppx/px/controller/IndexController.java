package com.ppx.px.controller;

import com.ppx.common.base.ResponseBase;
import com.ppx.common.constants.Constants;
import com.ppx.common.utils.CookieUtil;
import com.ppx.px.service.MemberServiceFeign;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;

@Controller
public class IndexController {
    private static final String INDEX = "index";
    @Autowired
    private MemberServiceFeign memberServiceFegin;
    @GetMapping("/")
    public ModelAndView index(HttpServletRequest reqest){
        // 1.从cookie中获取 token信息
        String token = CookieUtil.getUid(reqest, Constants.COOKIE_MEMBER_TOKEN);
        // 2.如果cookie 存在 token，调用会员服务接口，使用token查询用户信息
        if (!StringUtils.isEmpty(token)) {
            ResponseBase responseBase = memberServiceFegin.findByTokenUser(token);
            if (responseBase.getRtnCode().equals(Constants.HTTP_RES_CODE_200)) {
                LinkedHashMap userData = (LinkedHashMap) responseBase.getData();
                String username = (String) userData.get("username");
                reqest.setAttribute("username", username);
            }
        }
        return new ModelAndView("login");
    }
}
