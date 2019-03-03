package com.ppx.ppxes.base;

import org.omg.PortableInterceptor.HOLDING;

/**
 * 房源状态
 */
public enum HouseStatus {

    NOT_AUDITED(0, "未审核"),
    PASSES(1, "审核通过"),
    RENTED(2, "已退租"),
    DELETED(3, "已删除");

    private int value;

    private String desc;

    HouseStatus(int value, String desc){
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
