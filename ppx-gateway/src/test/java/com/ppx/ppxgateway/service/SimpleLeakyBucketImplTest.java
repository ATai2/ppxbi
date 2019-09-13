package com.ppx.ppxgateway.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j
public class SimpleLeakyBucketImplTest {

    private SimpleLeakyBucketImpl<String> bucket;

    @Test
    public void receive() throws InterruptedException {
        bucket = new SimpleLeakyBucketImpl<>(10, 100);
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 50; i++) {
            final int ii = i;
            Thread.sleep(r.nextInt(100));
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean isReceived = bucket.receive("请求" + ii);
                    if (isReceived) {
                        log.info("请求" + ii + "被接收");
                    } else {
                        log.info("请求" + ii + "被拒绝");
                    }
                }
            });
            t.start();

        }

        Thread.sleep(1000);
        log.info(bucket.getHandleCount() + "");
        log.info(bucket.getReceiveCount() + "");
    }
}