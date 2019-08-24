package com.ppx.common.base;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public interface RedisServer {
    <T> void put(String key, T obj);
    <T> void put(String key, T obj, int timeout);
    <T> void put(String key, T obj, int timeout, TimeUnit unit);

    <T> T get(String key, Class<T> cls);

//    <E,T extends Collection<E>> T get(String key, Class<E> cls, Class<T> collectionCls);
    <T> T putIfAbsent(String key, Class<T> cls, Supplier<T> supplier);
    <T> T putIfAbsent(String key, Class<T> cls, Supplier<T> supplier, int timeout);

//    <E,T extends Collection<E>> T putIfAbsent(String key, Class<E> cls, Class<T> collectionCls, Supplier<T> supplier);

    boolean exists(String key);
    void del(String key);
    boolean expire(String key, long timeout, TimeUnit unit);
    boolean expire(String key, long timeout);

    void put(String key, String value);
    void put(String key, String value, int timeout);
    void put(String key, String value, int timeout, TimeUnit unit);
    String get(String key);

    void putHash(String key, Map<Object, Object> m);
    Map<Object, Object> getHash(String key);
}
