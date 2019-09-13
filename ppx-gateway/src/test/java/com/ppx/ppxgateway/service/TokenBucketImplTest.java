package com.ppx.ppxgateway.service;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.Random;

public class TokenBucketImplTest {

    @Test
    public void main() throws InterruptedException {
        Bucket<String> tokenBucket = new TokenBucketImpl<>(10, 100);
        Thread.sleep(1000);
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 50; i++) {
            final int ii = i;
            Thread.sleep(r.nextInt(100));
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean isReceived = tokenBucket.receive("请求" + ii);
                    if (isReceived) {
                        System.out.println("请求" + ii + "被接收");
                    } else {
                        System.out.println("请求" + ii + "被拒绝");
                    }
                }
            });
            t.start();
        }
    }

    @Test
    public void test(){
        RateLimiter rateLimiter = RateLimiter.create(1.0);


//        StopWatch stopWatch=new StopWatch("test");
//        stopWatch.set
//        stopWatch.start("test");
    }
}