package com.ppx.ppxshiro.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
    private String name;
    private String password;
    private Integer id;
}
