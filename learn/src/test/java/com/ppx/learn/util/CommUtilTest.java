package com.ppx.learn.util;

import com.ppx.learn.domain.CityEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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