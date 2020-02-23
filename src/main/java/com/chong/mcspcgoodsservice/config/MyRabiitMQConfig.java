package com.chong.mcspcgoodsservice.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRabiitMQConfig {
    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        return  new Jackson2JsonMessageConverter();
    }

}
