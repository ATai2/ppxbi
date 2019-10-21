package com.ppx.core.lock;

public interface DistriLock {
    boolean tryLock();
    void unLock();
}
