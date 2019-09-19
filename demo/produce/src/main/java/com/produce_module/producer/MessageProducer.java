package com.produce_module.producer;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 生产者
 */
public class MessageProducer {

    //定义ActivMQ的连接地址
    private static final String ACTIVE_MQ_URL = "tcp://127.0.0.1:61616";
    //定义发送消息的队列名称
    private static final String QUEUE_NAME = "myJob";

    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createQueue(QUEUE_NAME);
        //创建一个生产者
        javax.jms.MessageProducer producer = session.createProducer(destination);
        //创建模拟100个消息
        for (int i = 1; i <= 100; i++) {
            TextMessage message = session.createTextMessage("我发送message:" + i);
            //发送消息
            producer.send(message);
            //在本地打印消息
            System.out.println("我现在发的消息是：" + message.getText());
        }
        //关闭连接
        connection.close();
    }

}
