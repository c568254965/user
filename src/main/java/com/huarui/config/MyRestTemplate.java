package com.huarui.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sloan on 2019/7/14.
 */


@Configuration
public class MyRestTemplate {

    @Bean
    @LoadBalanced
    public RestTemplate initMyRestTemplate(){
        return new RestTemplate();
    }



}
