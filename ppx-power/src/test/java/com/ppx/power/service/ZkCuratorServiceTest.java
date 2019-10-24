//package com.ppx.power.service;
//
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.framework.recipes.cache.NodeCache;
//import org.apache.curator.framework.recipes.cache.NodeCacheListener;
//import org.apache.curator.retry.RetryNTimes;
//import org.apache.zookeeper.CreateMode;
//import org.apache.zookeeper.ZooKeeper;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ZkCuratorServiceTest {
//
//    @Autowired
//    ZkService target;
//    private ZooKeeper zooKeeper;
//    private CuratorFramework client;
//
//    @Before
//    public void setUp() throws Exception {
//        client = CuratorFrameworkFactory.newClient("localhost:2181",
//                new RetryNTimes(3, 3));
//        client.start();
//    }
//
//    @Test
//    public void add() throws Exception {
//        client.create().withMode(CreateMode.EPHEMERAL).forPath("/data", "3".getBytes());
//    }
//    @Test
//    public void addWatcher() throws Exception {
//        NodeCache nodeCache=new NodeCache(client,"/data");
//        nodeCache.start();
//        nodeCache.getListenable().addListener(new NodeCacheListener() {
//            @Override
//            public void nodeChanged() throws Exception {
//                System.out.println("datachanged");
//            }
//        });
//
//        System.in.read();
//
//    }
//
//
//    @Test
//    public void getListRaw() {
//
//
//
//    }
//}