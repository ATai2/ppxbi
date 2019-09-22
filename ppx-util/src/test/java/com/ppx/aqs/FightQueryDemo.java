package com.ppx.aqs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class FightQueryDemo {

    private static List<String> company= Arrays.asList("东方航空","南方航空","海南航空");
    private static List<String> fightList=new ArrayList<>();

    public static void main2(String[] args) throws InterruptedException{
        String origin="BJ";
        String dest="SH";
        Thread[] threads=new Thread[company.size()];
        CountDownLatch latch=new CountDownLatch(company.size());

        for (int i = 0; i < threads.length; i++) {
            String name=company.get(i);
            threads[i]=new Thread(()->{
                System.out.printf("%s 查询从%s到%s的机票\n",name,origin,dest);
                //随机产生票数
                int val=new Random().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(val);
                    fightList.add(name+"--"+val);
                    System.out.printf("%s公司查询成功！\n",name);
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        latch.await();
        System.out.println("==============查询结果如下：================");
        fightList.forEach(System.out::println);
    }
}
