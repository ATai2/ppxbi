package com.ppx.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest<T> {
    private String code;
    private String msg;
    private T data;
}
