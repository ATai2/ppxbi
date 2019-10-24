package com.ppx.power.consumer;

import org.junit.Test;

import static org.junit.Assert.*;

public class KafkaConsumerDemoTest {

    @Test
    public void get() {
        KafkaConsumerDemo kafkaConsumerDemo=new KafkaConsumerDemo();
        kafkaConsumerDemo.get();
    }
}