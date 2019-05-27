package com.ppx.ppxshiro.domain;

import java.io.Serializable;

/**
 * @功能描述：用户类
 * @创建日期: 2019/2/22 20:21
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String perms;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
}
