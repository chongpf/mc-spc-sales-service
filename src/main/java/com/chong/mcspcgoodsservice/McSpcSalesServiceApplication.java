package com.chong.mcspcgoodsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.chong.common","com.chong.mcspcgoodsservice"})
@EnableFeignClients(basePackages = {"com.chong.mcspcgoodsservice.RemoteCall"})
@EnableHystrix
public class McSpcSalesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(McSpcSalesServiceApplication.class, args);
    }

}
