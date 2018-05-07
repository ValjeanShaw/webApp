package com.lucky.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.lucky")
public class BeanConfigFactory {
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


}
