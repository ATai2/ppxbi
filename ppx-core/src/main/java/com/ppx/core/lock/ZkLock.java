package com.ppx.core.lock;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZkLock implements DistriLock {

    private static final String LOCK_NAME = "/LOCK";
    private ThreadLocal<ZooKeeper> zk=new ThreadLocal<>();
    private ThreadLocal<String> currentNodeName=new ThreadLocal<>();

    public void init() {
        if (zk == null) {
            try {
                zk.set(new ZooKeeper("localhost:2181", 5000,
                        new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {

                    }
                }));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void lock(){
        init();
        if (tryLock()) {

        }
    }

    @Override
    public boolean tryLock() {
        String nodeName = LOCK_NAME + "/zk_";

        try {
            currentNodeName.set(zk.get().create(nodeName, new byte[0],
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL));
            List<String> list = zk.get().getChildren(LOCK_NAME, false);
            Collections.sort(list);
            String minNodeName = list.get(0);

            if (currentNodeName.get().equalsIgnoreCase(LOCK_NAME + "/" + minNodeName)) {
                return true;
            }else{
                String currentNodeSimpleName = currentNodeName.get().substring(currentNodeName.get().lastIndexOf("/") + 1);
                int currentNodeIndex = list.indexOf(currentNodeSimpleName);
                String prevNodeName = list.get(currentNodeIndex - 1);

                CountDownLatch countDownLatch=new CountDownLatch(1);

                zk.get().exists(LOCK_NAME + "/" + prevNodeName, new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        if (Event.EventType.NodeDeleted.equals(event.getType())) {
                            countDownLatch.countDown();
                        }
                    }
                });
                countDownLatch.await();
                return true;
            }

        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void unLock() {
        try {
            zk.get().delete(currentNodeName.get(),-1);
            currentNodeName=null;
            zk.get().close();
        } catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
    }
}
