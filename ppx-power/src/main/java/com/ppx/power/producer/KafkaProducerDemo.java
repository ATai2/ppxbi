package com.ppx.power.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerDemo {

    public void send(String msg){
        Properties properties=new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty("num.partitions=3", "3");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        KafkaProducer<String,String> kafkaProducer=new KafkaProducer<String, String>(properties);
        ProducerRecord<String,String> record=new ProducerRecord<String,String>("test_topic2",
                0,"test.key" ,msg);
        kafkaProducer.send(record);
        kafkaProducer.flush();
        kafkaProducer.close();




    }
}
