package com.lucky.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/kafka")
public class KafkaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    KafkaTemplate kafkaTemplate;


    @RequestMapping("/sendSimpleMess")
    @ResponseBody
    public String sendKafkaMess(){

        kafkaTemplate.send("topicOne","this is kafka mess");

        return "kafka mess has sent";
    }


}
