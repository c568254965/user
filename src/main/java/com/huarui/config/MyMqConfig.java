package com.huarui.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import javax.jms.Queue;

/**
 * Created by sloan on 2019/7/16.
 */


@Component
@EnableJms
@ConfigurationProperties
public class MyMqConfig {


    @Value("${orderQueue}")
    private String orderQueue;



    @Bean(value = "quque")
    public Queue quque(){
        return new ActiveMQQueue(orderQueue);
    }



}
