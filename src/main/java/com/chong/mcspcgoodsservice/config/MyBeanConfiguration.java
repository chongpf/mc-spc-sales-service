package com.chong.mcspcgoodsservice.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyBeanConfiguration {

    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        return  new Jackson2JsonMessageConverter();
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
