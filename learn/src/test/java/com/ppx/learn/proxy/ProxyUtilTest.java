package com.ppx.learn.proxy;

import com.ppx.learn.dao.LubanDao;
import com.ppx.learn.dao.LubanDaoImpl;
import com.ppx.learn.dao.LubanInvocationHandler;
import org.junit.Test;

import java.lang.reflect.Proxy;


public class ProxyUtilTest {

    @Test
    public void newInstance() {
//        ProxyUtil.newInstance(new LubanDaoImpl());

         LubanDao lubanDao = (LubanDao) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                 new Class[]{LubanDao.class},
                 new LubanInvocationHandler(new LubanDaoImpl()));
         lubanDao.query();

    }
}