//package com.ppx.ppxes.base;
//
//import com.sofang.entity.User;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//public class LoginUserUtil {
//
//    /**
//     * 获取当前登录用户
//     * @return
//     */
//    public static User load(){
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if(principal != null && principal instanceof User){
//            return (User)principal;
//        }
//        return null;
//    }
//
//    public static Long getLoginUser(){
//        User user = load();
//        if(user == null){
//            return -1L;
//        }
//        return user.getId();
//    }
//}
