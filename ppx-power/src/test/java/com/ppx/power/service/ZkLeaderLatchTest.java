//package com.ppx.power.service;
//
//import com.google.common.collect.Lists;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.framework.recipes.leader.LeaderLatch;
//import org.apache.curator.framework.recipes.leader.LeaderSelector;
//import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
//import org.apache.curator.framework.state.ConnectionState;
//import org.apache.curator.retry.RetryNTimes;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class ZkLeaderLatchTest {
//    List<CuratorFramework> clients= Lists.newArrayList();
//    List<LeaderLatch> leaderLatches=Lists.newArrayList();
//    List<LeaderSelector> leaderSelectors=Lists.newArrayList();
//    private CuratorFramework client;
//
//    @Before
//    public void setUp() throws Exception {
//        client = CuratorFrameworkFactory.newClient("localhost:2181",
//                new RetryNTimes(3, 3));
//        client.start();
//    }
//    @Test
//    public void test() throws Exception {
//        for (int i = 0; i < 10; i++) {
//            CuratorFramework client0 = CuratorFrameworkFactory.newClient("localhost:2181",
//                    new RetryNTimes(3, 3));
//            clients.add(client0);
//            client0.start();
//            LeaderLatch leaderLatch = new LeaderLatch(client0, "/leadlatch", "client#" + i);
//            leaderLatches.add(leaderLatch);
//            leaderLatch.start();
//        }
//        TimeUnit.SECONDS.sleep(5);
//        for (LeaderLatch l :
//                leaderLatches) {
//            if (l.hasLeadership()) {
//                System.out.println("当前leader是："+l.getId());
//                break;
//            }
//        }
//        System.in.read();
//    } @Test
//    public void testSelector() throws Exception {
//        for (int i = 0; i < 10; i++) {
//            CuratorFramework client0 = CuratorFrameworkFactory.newClient("localhost:2181",
//                    new RetryNTimes(3, 3));
//            clients.add(client0);
//            client0.start();
//
//            LeaderSelector leaderSelector=new LeaderSelector(client0, "/leadselector",
//                    new LeaderSelectorListener() {
//                @Override
//                public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
//                    System.out.println("当前leader："+curatorFramework);
//                }
//
//                @Override
//                public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {
//
//                }
//            });
//            leaderSelector.start();
//            leaderSelectors.add(leaderSelector);
//        }
//        TimeUnit.SECONDS.sleep(5);
//        for (LeaderSelector l :
//                leaderSelectors) {
//            if (l.hasLeadership()) {
//                System.out.println("当前leader是："+l.getId());
//                break;
//            }
//        }
//        System.in.read();
//    }
//
//    @After
//    public void tearDown(){
//        for (CuratorFramework c :
//                clients) {
//            c.close();
//        }
//    }
//}
