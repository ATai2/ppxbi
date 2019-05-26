package com.ppx.ppxshiro.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("shou quan");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("ren zheng");
        String name = "atai";
        String password="asdf";

        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        if (!token.getUsername().equals(name)) {
            return null;
        }
        return new SimpleAuthenticationInfo("",password,"");
    }
}
