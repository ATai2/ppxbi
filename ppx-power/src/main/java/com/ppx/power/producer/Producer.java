package com.ppx.power.producer;

import com.ppx.power.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public void send(String msg) {
        Channel channel = null;
        try {
            Connection connection = ConnectionUtil.getConnection();
            channel = connection.createChannel();
            channel.queueDeclare(ConnectionUtil.QUEUE_NAME, true, false, false, null);
            channel.basicPublish("",ConnectionUtil.QUEUE_NAME,null,msg.getBytes());
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


}
