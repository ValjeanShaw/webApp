package com.lucky.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class rabbitmqConsumerFanout {
    private static final Logger LOGGER = LoggerFactory.getLogger(rabbitmqConsumerFanout.class);
    /**
     * 消息消费者
     */
    public void consumerMessFanoutOne(String mess){
        LOGGER.info("第一个接收者接到:{}",mess);
    }

    /**
     * 消息消费者
     */
    public void consumerMessFanoutTwo(String mess){
        LOGGER.info("第二个接收者接到:{}",mess);
    }
}
