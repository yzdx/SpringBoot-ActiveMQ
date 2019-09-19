package com.produce_module.controller;

import com.alibaba.fastjson.JSONObject;
import com.produce_module.entities.News;
import com.produce_module.listener.UUIDKit;
import com.produce_module.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.List;


@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newService;

    @Autowired
    private Topic topic ;

     @Autowired
     private Queue queue ;

     @Autowired
     private JmsMessagingTemplate jms ;



    @RequestMapping("/queue")
     public String queue(){
        //数据处理
        JSONObject json = new JSONObject();
        json.put("newId", UUIDKit.getUUID());
        json.put("newsName", "新闻联播");
        json.put("content", "习近平总书记飞往湖北，体察明清。");
        jms.convertAndSend(queue, json);
         return "success" ;
     }


    @JmsListener(destination = "OUT_QUEUE")
    public void consumerMsg(String msg){
        System.out.println("接受消费者反馈结果为：" + msg);
    }

    @RequestMapping("/topic")
    public String topic(){
            //数据处理
        JSONObject json = new JSONObject();
        json.put("newId", UUIDKit.getUUID());
        json.put("newsName", "新闻联播");
        json.put("content", "习近平总书记飞往湖北，体察明清。");
        jms.convertAndSend(queue, json);
        return "top send success !" ;
    }

    @RequestMapping(name = "/getAll")
    public List<News> getAll() {
        List<News> allNews = newService.getAll();
        return allNews;
    }


}
