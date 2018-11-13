package com.ppx.ppxusermgt.dao;

import com.ppx.ppxusermgt.entity.PpxUser;
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
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        PpxUser userDO = new PpxUser();
        userDO.setUserId(1L);
        userDO.setUserName("风清扬");
        userDO.setPwd("123456");
        userDao.save(userDO);
        userDO = new PpxUser();
        userDO.setUserId(3L);
        userDO.setUserName("东方不败");
        userDO.setPwd("123456");
        userDao.save(userDO);
    }

    @Test
    public void testAdd() {
        PpxUser userDO = new PpxUser();
        userDO.setUserId(2L);
        userDO.setUserName("风清扬34");
        userDO.setPwd("123456");
        userDao.save(userDO);
        userDO = new PpxUser();
        userDO.setUserId(4L);
        userDO.setUserName("东方不败343");
        userDO.setPwd("123456");
        userDao.save(userDO);
    }

    @After
    public void tearDown() throws Exception {
        userDao.deleteById(1L);
        userDao.deleteById(3L);
    }
}