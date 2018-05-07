package com.lucky.controller;

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

    @Autowired
    @Qualifier("sendNoticeTemplate")
    private RabbitTemplate messProducer;

    @Resource(name = "sendNoticeTemPlateFanout")
    RabbitTemplate sendNoticeTemPlateFanout;


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
}
