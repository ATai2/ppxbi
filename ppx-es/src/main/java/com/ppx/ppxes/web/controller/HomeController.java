package com.ppx.ppxes.web.controller;

import com.ppx.ppxes.base.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
@Controller
public class HomeController {

//    @ResponseBody
//    @GetMapping("/get")
//    public ApiResponse get(){
//        return ApiResponse.ofMessage(200, "速度快九分");
//    }

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/404")
    public String notFoundPage() {
        return "404";
    }

    @GetMapping("/403")
    public String accessError() {
        return "403";
    }

    @GetMapping("/500")
    public String internalError() {
        return "500";
    }

    @GetMapping("/logout/page")
    public String logoutPage() {
        return "logout";
    }

    @ResponseBody
    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.createBySuccessMessage("Success!");
    }
}
