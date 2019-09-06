package com.ppx.ppxlitemalldb.service;

import com.ppx.ppxlitemalldb.domain.LitemallUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LitemallUserServiceTest {

    @Autowired
    LitemallUserService litemallUserService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        LitemallUser byId = litemallUserService.findById(1);
        System.out.println(byId);
    }

    @Test
    public void findUserVoById() {
    }

    @Test
    public void queryByOid() {
    }

    @Test
    public void add() {
    }

    @Test
    public void updateById() {
    }

    @Test
    public void querySelective() {
    }

    @Test
    public void count() {
    }

    @Test
    public void queryByUsername() {
    }

    @Test
    public void checkByUsername() {
    }

    @Test
    public void queryByMobile() {
    }

    @Test
    public void queryByOpenid() {
    }

    @Test
    public void deleteById() {
    }
}