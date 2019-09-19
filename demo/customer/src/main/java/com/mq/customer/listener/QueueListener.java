package com.mq.customer.listener;

import com.alibaba.fastjson.JSONObject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

    @JmsListener(destination = "myJob")
    @SendTo("OUT_QUEUE")
    public String receive(JSONObject text){
        System.out.println("接受生产者信息为：" + text);
        return "接受生产者信息为：" + text;

    }


}
