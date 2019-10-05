//package com.ppx.learn.proxy;
//
//import com.ppx.learnspring.dao.LubanDao;
//import com.ppx.learnspring.dao.LubanDaoImpl;
//import com.ppx.learnspring.dao.LubanInvocationHandler;
//import com.ppx.learnspring.proxy.ProxyUtil;
//import org.junit.Test;
//
//import java.lang.reflect.Proxy;
//
//
//public class ProxyUtilTest {
//
//    @Test
//    public void newInstance() throws ClassNotFoundException {
////        ProxyUtil.newInstance(new LubanDaoImpl());
//
//        LubanDao lubanDao = (LubanDao) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
//                new Class[]{LubanDao.class},
//                new LubanInvocationHandler(new LubanDaoImpl()));
//        lubanDao.query();
//
//
//
//        Class.forName("");
//
//    }
//}