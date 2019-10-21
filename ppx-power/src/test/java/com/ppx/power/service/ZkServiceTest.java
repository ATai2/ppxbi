package com.ppx.power.service;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZkServiceTest {

    @Autowired
    ZkService target;
    private ZooKeeper zooKeeper;

    @Before
    public void setUp() throws Exception {
        zooKeeper = new ZooKeeper("localhost:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("连接时" + watchedEvent);
            }
        });
    }

    @Test
    public void add(){
//        zooKeeper.setData("/ppx", "ppxvalue".getBytes());
    }

    @Test
    public void getListRaw() {
//        target.getList();
        try {

            Stat stat=new Stat();
            byte[] data = zooKeeper.getData("/luban", new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (Event.EventType.NodeDataChanged.equals(watchedEvent.getType())) {
                        System.out.println("data changed");
                    }
                }
            }, stat);
            System.out.println(String.valueOf(data));
            System.in.read();
        } catch (IOException | InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
    }
}