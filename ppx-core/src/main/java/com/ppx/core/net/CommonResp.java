package com.ppx.core.net;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class CommonResp<T> {
    private Integer code;
    private String msg;
    private T data;
}
