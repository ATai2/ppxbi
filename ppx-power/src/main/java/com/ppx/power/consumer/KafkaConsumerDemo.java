package com.ppx.power.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerDemo {
    public void get(){
        Properties properties=new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());

        properties.setProperty("group.id", "1111");

        KafkaConsumer<String,String> kafkaConsumer=new KafkaConsumer<String, String>(properties);
        kafkaConsumer.subscribe(Collections.singletonList("test_topic"));

        while (true) {
            ConsumerRecords<String, String> poll = kafkaConsumer.poll(500);
            for (ConsumerRecord<String, String> context :
                    poll) {
                System.out.println("Partition:"+context.partition()+" offset:"
                        +context.offset()+" key:"+context.key()+" value:"+context.value());


            }
        }

    }
}
