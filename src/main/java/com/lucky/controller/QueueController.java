package com.lucky.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/queue")
public class QueueController {

    @Resource(name = "sendNoticeTemplate")
    private RabbitTemplate messProducer;


    @RequestMapping(value = "/rabbitmq")
    @ResponseBody
    public String rabbitMq(){
        messProducer.convertAndSend("test_queue_key","hello rabbitmq mess");
        return "rabbitmq is sent";
    }
}
