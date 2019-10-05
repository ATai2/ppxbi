package com.ppx.learn.util;

import com.ppx.learnspring.domain.CityEntity;
import com.ppx.learnspring.util.CommUtil;
import org.junit.Before;
import org.junit.Test;

public class CommUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void buildQuerySqlFromEntity() {
        CityEntity cityEntity=new CityEntity();
        cityEntity.setId("3");
        cityEntity.setName("ddd");
        CommUtil.buildQuerySqlFromEntity(cityEntity);
    }
}