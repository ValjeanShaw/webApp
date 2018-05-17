package com.lucky.queue;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;


public class kafkaConsumer implements MessageListener<String,String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageListener.class);

    public void onMessage(ConsumerRecord<String, String> record) {
        LOGGER.info("kafkaConsumer 2 开始消费，键:" + JSON.toJSONString(record.key()));
        LOGGER.info("kafkaConsumer 2 开始消费，内容:" + JSON.toJSONString(record.value()));
        LOGGER.info("kafkaConsumer 2 开始消费，topic:" + JSON.toJSONString(record.topic()));
        LOGGER.info("kafkaConsumer 2 开始消费，offset:" + JSON.toJSONString(record.offset()));
        LOGGER.info("kafkaConsumer 2 开始消费，partition:" + JSON.toJSONString(record.partition()));
    }
}
