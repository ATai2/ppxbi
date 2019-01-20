package com.ppx.ppxorder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PpxUser {
    private long userId;
    private String userName;
    private String pwd;
    private String role;
}
