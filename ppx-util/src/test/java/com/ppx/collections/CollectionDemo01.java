package com.ppx.collections;

import java.util.concurrent.ConcurrentLinkedDeque;

public class CollectionDemo01 {
    public static void main(String[] args) throws InterruptedException{
        ConcurrentLinkedDeque<String> list=new ConcurrentLinkedDeque();
        //添加数据
        Thread[] add=new Thread[100];
        for (int i = 0; i < 100; i++) {
            add[i]=new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    list.add(Thread.currentThread().getName()+":Element "+j);
                }
            });
            add[i].start();
            add[i].join();
        }
        System.out.println("after add size:"+list.size());

        //移除数据

        Thread[] poll=new Thread[100];
        for (int i = 0; i < 100; i++) {
            poll[i]=new Thread(()->{
                for (int j = 0; j < 5000; j++) {
                    list.pollLast();
                    list.pollFirst();
                }
            });
            poll[i].start();
            poll[i].join();
        }
        System.out.println("after poll size:"+list.size());
    }
}
