package com.ppx.message.api.base;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseBase {
    private String code;
    private String message;
    private Object data;
}
