package com.ppx.power.producer;

import org.junit.Test;

public class KafkaProducerDemoTest {

    @Test
    public void send() {
        KafkaProducerDemo kafkaProducerDemo=new KafkaProducerDemo();
        kafkaProducerDemo.send("23232");
    }
}