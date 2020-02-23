package com.chong.mcspcgoodsservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.chong.common","com.chong.mcspcgoodsservice"})
@EnableFeignClients(basePackages = {"com.chong.mcspcgoodsservice.RemoteCall"})
@EnableHystrix
@EnableCaching
@EnableSwagger2
@MapperScan("com.chong.mcspcgoodsservice.dao")
public class McSpcSalesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(McSpcSalesServiceApplication.class, args);
    }

}
