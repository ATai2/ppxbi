package com.ppx.ppxusermgt.utils;

public interface Lock {
    void lock(String key);
    boolean tryLock(String key);
    void unlock(String key) throws Exception;
}
