package com.ppx.admin.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class StatVo {
    private String[] columns = new String[0];
    private List<Map> rows = new ArrayList<>();
}
