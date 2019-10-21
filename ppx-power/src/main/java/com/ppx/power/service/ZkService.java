package com.ppx.power.service;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ZkService {
    public List<String> getList() {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("连接时" + watchedEvent);
                }
            });
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
