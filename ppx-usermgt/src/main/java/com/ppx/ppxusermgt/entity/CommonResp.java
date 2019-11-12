package com.ppx.ppxusermgt.entity;

import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class CommonResp<T> {
    public static final String SUCCESS = "SUCCESS";
    private int code=0;
    private String msg= SUCCESS;
    private T data;
}
