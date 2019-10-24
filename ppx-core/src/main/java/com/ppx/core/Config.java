//package com.ppx.core;
//
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.framework.recipes.cache.PathChildrenCache;
//import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
//import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
//import org.apache.curator.retry.RetryNTimes;
//import org.apache.zookeeper.CreateMode;
//import org.apache.zookeeper.data.Stat;
//
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class Config {
//
//    private Map<String, String> cache = new ConcurrentHashMap<>();
//    private CuratorFramework client;
//    private static final String CONFIG_PREFIX = "/config";
//
//    public Config() {
//        this.client = CuratorFrameworkFactory.newClient("localhost:2181",
//                new RetryNTimes(3, 5000));
//        client.start();
//        init();
//    }
//
//    public void init() {
//        try {
//            List<String> childrenNames = client.getChildren().forPath(CONFIG_PREFIX);
//            for (String name :
//                    childrenNames) {
//                String value = new String(client.getData().forPath(CONFIG_PREFIX + "/" + name));
//                cache.put(name, value);
//            }
//
//            PathChildrenCache watcher = new PathChildrenCache(client, CONFIG_PREFIX, true);
//            watcher.getListenable().addListener(new PathChildrenCacheListener() {
//                @Override
//                public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
//                    String path = event.getData().getPath();
//                    if (path.startsWith(CONFIG_PREFIX)) {
//                        String key = path.replace(CONFIG_PREFIX+"/", "");
//                        if (PathChildrenCacheEvent.Type.CHILD_ADDED.equals(event.getType())
//                                ||PathChildrenCacheEvent.Type.CHILD_UPDATED.equals(event.getType())) {
//                            cache.put(key, new String(event.getData().getData()));
//                        } else if (PathChildrenCacheEvent.Type.CHILD_REMOVED.equals(event.getType())) {
//                            cache.remove(key);
//                        }
//                    }
//                }
//            });
//            watcher.start();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void save(String name, String value) {
//        String configFullName = CONFIG_PREFIX + "/" + name;
////        zk
//        try {
//            Stat stat = client.checkExists().forPath(configFullName);
//            if (stat == null) {
//                client.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath(configFullName, value.getBytes());
//            } else {
//                client.setData().forPath(configFullName, value.getBytes());
//            }
//
//            cache.put(name, value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        cache
//
//    }
//
//    public String get(String name) {
//        return cache.get(name);
//    }
//}
