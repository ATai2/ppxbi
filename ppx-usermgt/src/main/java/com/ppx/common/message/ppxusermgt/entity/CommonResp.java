package com.ppx.common.message.ppxusermgt.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommonResp<T> {
    public static final String SUCCESS = "SUCCESS";
    private int code=0;
    private String msg= SUCCESS;
    private T data;
}
