package com.chong.mcspcgoodsservice.sales.controller;

import com.chong.common.entity.ResponseData;
import com.chong.mcspcgoodsservice.sales.entity.Order;
import com.chong.mcspcgoodsservice.service.SendOrderCuidQueueService;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "集成消息队列功能的controller")
@RestController
@RequestMapping("/asyn")
public class AsynOrderController {

    @Autowired
    SendOrderCuidQueueService sendOrderCuidQueueService;

    private static final Logger logger = LoggerFactory.getLogger(AsynOrderController.class);

    @PostMapping("/order/create/{orderId}")
    public ResponseData createOrderById(@PathVariable("orderId") String orderId){
        Order order = new Order();
        order.setId(Integer.parseInt(orderId));
        sendOrderCuidQueueService.sendOrderCreate(order);
        logger.info("controller send order-create is success.");
        return null;
    }


    @PostMapping("/order/cancel/{orderId}")
    public ResponseData cancelOrderById(@PathVariable("orderId") String orderId){
        Order order = new Order();
        order.setId(Integer.parseInt(orderId));
        sendOrderCuidQueueService.sendOrderCancel(order);
        logger.info("controller send order-cancel is success.");
        return null;
    }

}
