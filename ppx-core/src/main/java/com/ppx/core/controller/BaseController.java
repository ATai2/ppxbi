package com.ppx.core.controller;

import com.ppx.core.R;

public class BaseController {

    public R fallbackMethod(String msg){
        return R.error("降级信息").set("content",msg);
    }
}
