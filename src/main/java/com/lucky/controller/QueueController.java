package com.lucky.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/queue")
public class QueueController {
    private static final Logger LOGGER = LoggerFactory.getLogger(QueueController.class);

    @Autowired
    @Qualifier("sendNoticeTemplate")
    private RabbitTemplate messProducer;

    @Resource(name = "sendNoticeTemPlateFanout")
    RabbitTemplate sendNoticeTemPlateFanout;

    @Resource(name = "sendNoticeTemPlateTopic")
    RabbitTemplate sendNoticeTemPlateTopic;


    @RequestMapping(value = "/rabbitmq")
    @ResponseBody
    public String rabbitMq() {
        messProducer.convertAndSend("test_queue_key", "hello rabbitmq mess");
        return "rabbitmq is sent";
    }

    @RequestMapping(value = "/rabbitmqFanout")
    @ResponseBody
    public String rabbitMqFanout() {
        sendNoticeTemPlateFanout.convertAndSend("fanoutExchange","","this is fanout mess");
        return "rabbitmq fanout is sent";
    }


    @RequestMapping(value = "/rabbitmqTopic")
    @ResponseBody
    public String rabbitMqTopic(String channel){
        String routerKey = "";
        try{
            int num = 0;
            num = Integer.parseInt(channel);
            switch(num){
                case 1:
                    routerKey = "weather-router.abc";
                    break;
                case 2:
                    routerKey = "weather-router.abc.bcd";
                    break;
                case 3:
                    routerKey = "msg-router.abc";
                    break;
                case 4:
                    routerKey = "msg-router.abc.bcd";
                    break;
            }

            sendNoticeTemPlateTopic.convertAndSend("topicExchange",routerKey,routerKey.toString());
        }catch(Exception e){
            LOGGER.error("系统出错:{}",e);
        }
        return "rabbitmq topic is out";
    }
}
