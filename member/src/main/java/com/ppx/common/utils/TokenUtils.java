package com.ppx.common.utils;

import com.ppx.common.base.Constants;

import java.util.UUID;

public class TokenUtils {
    public static String getToken(){
        return Constants.TOKEN_MEMBER+ UUID.randomUUID();
    }
}
