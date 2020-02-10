package com.chong.mcspcgoodsservice.sales.controller;

import com.chong.common.entity.ResponseData;
import com.chong.common.util.ResponseUtil;
import com.chong.mcspcgoodsservice.RemoteCall.Order.OrderRemoteClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private RestTemplate restTemplate;

    private OrderRemoteClient orderRemoteClient;

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @Autowired
    public SalesController(RestTemplate restTemplate,
                           OrderRemoteClient orderRemoteClient
                           ){
        this.restTemplate = restTemplate;
        this.orderRemoteClient = orderRemoteClient;
    }

    @GetMapping(value="/{orderId}")
    public ResponseData getOrderByFeign(@PathVariable("orderId") String orderId){
        ResponseData responseData = orderRemoteClient.getOrder(orderId);
        responseData.setMessage(responseData.getMessage()+"===== macroSales:"+instanceId);
        return responseData;
    }


    @GetMapping(value="/hostport/{orderId}")
    public ResponseData getOrderByHostPort(@PathVariable("orderId") String orderId){
        // 如果使用localhost访问，需要去掉RestTemplate Bean的@Loadbalanced注解
        ResponseData responseData = restTemplate.getForObject("http://localhost:9010/order/{orderId}",ResponseData.class,orderId);
        return responseData;
    }

    @GetMapping(value="/servicename/{orderId}")
    public ResponseData getOrderByServiceName(@PathVariable("orderId") String orderId){
        ResponseData responseData = restTemplate.getForObject("http://mc-spc-order-service/order/{orderId}",ResponseData.class,orderId);
        return responseData;
    }

    @GetMapping("/hystrix/{orderId}")
    @HystrixCommand(fallbackMethod ="getOrderWithHystrixFallback" )
    public ResponseData getOrderWithHystrix(@PathVariable("orderId")
                                                        String orderId){
        ResponseData responseData = restTemplate.getForObject("http://mc-spc-order-service/order/{orderId}",ResponseData.class,orderId);
        return responseData;
    }
    @GetMapping("/error/{orderId}")
    @HystrixCommand(fallbackMethod ="getOrderWithHystrixFallback" )
    public ResponseData getOrderWithHystrixException(@PathVariable("orderId")
                                                    String orderId){
        throw new RuntimeException("hand occurr error");
    }

    private ResponseData getOrderWithHystrixFallback(String orderId){
        return ResponseUtil.fail(1001,"errorOccurredToHystrix"+": orderId-"+orderId);
    }
}

