package com.ppx.admin.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class CatVo {
    private Integer value = null;
    private String label = null;
    private List children = null;

}
