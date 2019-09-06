package com.ppx.common.ppxutil.demos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResp<T> {
    private String code;
    private String msg;
    private T data;
}
