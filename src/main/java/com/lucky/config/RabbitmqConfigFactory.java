package com.lucky.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 存放rabbitmq的配置
 */
@Configuration
@ComponentScan(basePackages = "com.lucky")
public class RabbitmqConfigFactory {

    //创建rabbitmq的消息队列，使用fanout转发器
    //fanout转发器是广播的概念，绑定该转发器的队列，都能收到一份消息
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    //创建两个队列，用于绑定fanout转发器
    @Bean
    public Queue queueForFanoutOne() {
        return new Queue("queueforfanoutone", true);
    }

    @Bean
    public Queue queueForFanoutTwo() {
        return new Queue("queueforfanouttwo", true);
    }

    //绑定以上两个queue到fanout中
    @Bean
    public Binding bindingQueueOne() {
        return BindingBuilder.bind(queueForFanoutOne()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingQueueTwo(){
        return BindingBuilder.bind(queueForFanoutTwo()).to(fanoutExchange());
    }


    /***************************************************
     *
     * topic转发器转发消息队列
     *
     */
    private static final String ROUTERKEY_1 = "weather-router.*"; //  *  后面一个单词
    private static final String ROUTERKEY_2 = "msg-router.#";    //   #  后面多个单词模糊匹配

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    //创建两个队列
    @Bean
    public Queue queueOneForTopic(){
        return new Queue("queueOneForTopic",true);
    }

    @Bean
    public Queue queueTwoForTopic(){
        return new Queue("queueTwoForTopic",true);
    }

    //绑定转发器
    @Bean
    public Binding bindingTopicQueueOne(){
        return BindingBuilder.bind(queueOneForTopic()).to(topicExchange()).with(ROUTERKEY_1);
    }

    @Bean
    public Binding bindingTopicQueueTwo(){
        return BindingBuilder.bind(queueTwoForTopic()).to(topicExchange()).with(ROUTERKEY_2);
    }



}
