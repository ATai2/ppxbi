package com.ppx.ppxlitemalldb.dao;

import com.ppx.ppxlitemalldb.domain.LitemallSystem;
import com.ppx.ppxlitemalldb.domain.LitemallSystemExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class LitemallSystemMapperTest {

    @Autowired
    LitemallSystemMapper litemallSystemMapper;

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectOneByExample() {
    }

    @Test
    public void selectOneByExampleSelective() {
    }

    @Test
    public void selectByExampleSelective() {
    }

    @Test
    public void selectByExample() {


        LitemallSystemExample example = new LitemallSystemExample();
        example.or().andKeyNameLike("litemall_wx_%").andDeletedEqualTo(false);

        List<LitemallSystem> litemallSystems = litemallSystemMapper.selectByExample(example);
    }

    @Test
    public void selectByPrimaryKeySelective() {
    }
}