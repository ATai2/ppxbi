//package com.ppx.ppxactiviti.controller;
//
//import com.ppx.ppxactiviti.entity.UserEntity;
//import org.activiti.engine.IdentityService;
//import org.activiti.engine.impl.persistence.entity.UserEntityImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.transaction.Transactional;
//
//@RestController
//@RequestMapping("/test")
//public class TestController {
//    @Autowired
//    private IdentityService identityService;
//
//    @RequestMapping("/test")
//    @ResponseBody
//    public String test(){
//        return "ldkf";
//    }
//
//    @Transactional(Transactional.TxType.REQUIRED)
//    @GetMapping("/user")
//    public String user(HttpServletRequest request) {
//        String id = request.getParameter("id");
////        UserEntity user=new UserEntity();
//        UserEntityImpl user=new UserEntityImpl();
//        user.setId(id);
//        user.setRevision(1);
//        identityService.saveUser(user);
//        return user.toString();
//    }
//}
