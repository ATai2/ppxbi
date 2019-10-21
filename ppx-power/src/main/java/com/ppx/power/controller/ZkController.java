package com.ppx.power.controller;

import com.ppx.core.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZkController {
    @GetMapping("/zks")
    public R getZk() {

        return R.success();
    }
}
