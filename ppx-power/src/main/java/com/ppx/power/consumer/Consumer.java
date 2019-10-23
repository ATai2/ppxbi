package com.ppx.power.consumer;

import com.ppx.power.utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public void consume() {
        try {
            Connection connection = ConnectionUtil.getConnection();
            Channel channel = connection.createChannel();
            DefaultConsumer deliverCallBack=new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println(new String(body, Charset.defaultCharset()));
                    System.out.println("msg consumed");
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            };
            channel.basicConsume(ConnectionUtil.QUEUE_NAME, deliverCallBack);
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
