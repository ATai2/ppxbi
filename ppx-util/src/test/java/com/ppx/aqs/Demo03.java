package com.ppx.aqs;

import java.util.concurrent.locks.ReentrantLock;

public class Demo03 {
    private ReentrantLock lock=new ReentrantLock();
    private int m=0;
    public void a(){
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }
    public void b(){
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {
        Demo03 demo=new Demo03();
        new Thread(()->{
            demo.a();
        }).start();
    }
}
