package com.lucky.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class rabbitmqConsumerTopic {

    private static final Logger LOGGER = LoggerFactory.getLogger(rabbitmqConsumerTopic.class);

    public void consumerMessTopicOne(String mess){
        LOGGER.info("第一个接收者接到:{}",mess);
    }

    /**
     * 消息消费者
     *   msg-router.#
     */
    public void consumerMessTopicTwo(String mess){
        LOGGER.info("第二个接收者接到:{}",mess);
    }
}
