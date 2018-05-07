package com.lucky.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * rabbitmq的消息消费者   主要接收direct转发器消息
 */
public class rabbitmqConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(rabbitmqConsumerFanout.class);

    /**
     * 消息消费者
     */
    public void consumerMess(String mess){
        LOGGER.info("dirct转发器接收到消息：{}",mess);
    }


}
