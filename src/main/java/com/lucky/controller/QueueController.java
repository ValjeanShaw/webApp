package com.lucky.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    @Qualifier("sendNoticeTemplate")
    private RabbitTemplate messProducer;


    @RequestMapping(value = "/rabbitmq")
    @ResponseBody
    public String rabbitMq(){
        messProducer.convertAndSend("test_queue_key","hello rabbitmq mess");
        return "rabbitmq is sent";
    }
}
