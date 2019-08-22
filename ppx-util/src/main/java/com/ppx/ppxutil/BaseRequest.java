package com.ppx.ppxutil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest<T> {
    private String code;
    private String msg;
    private T data;
}
