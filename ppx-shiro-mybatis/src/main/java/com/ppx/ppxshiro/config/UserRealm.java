package com.ppx.ppxshiro.config;

import com.ppx.ppxshiro.domain.User;
import com.ppx.ppxshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @功能描述：TODO
 * @创建日期: 2019/2/22 18:56
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        //System.out.println(subject.getPrincipal());
        User dbUser = userService.findById(user.getId());
       // info.addStringPermission("user:add");
        info.addStringPermission(dbUser.getPerms());
        return info;
    }


    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        //编写shiro判断逻辑，判断用户名和密码
        UsernamePasswordToken token  =  (UsernamePasswordToken)authenticationToken;

        User user = userService.findByName(token.getUsername());

        //1、判断用户名
        if(user == null){
            //用户名不存在
            return null; //shiro底层会抛出UnKnowAccountException
        }

        //2、判断密码, 这里的user是principal
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }


}
