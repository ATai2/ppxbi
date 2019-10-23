package com.ppx.power.producer;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProducerTest {

    @Test
    public void send() {
        Producer producer=new Producer();
        producer.send("dddd65");
    }
}