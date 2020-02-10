package com.chong.mcspcgoodsservice.service;

import com.chong.common.util.ObjectMapperUtil;
import com.chong.mcspcgoodsservice.sales.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SendOrderCuidQueueService {
    private static final Logger logger = LoggerFactory.getLogger(SendOrderCuidQueueService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${exchange-name.mc-spc-order-service}")
    private String exchangeOrder;

    @Value("${routing-key.order-create.mc-spc-order-service}")
    private String queueOrderCreateKey;

    @Value("${routing-key.order-cancel.mc-spc-order-service}")
    private String queueOrderCancelKey;

    @Value("${routing-key.order-create-result.mc-spc-sales-service}")
    private String queueOrderCreateResultKey;

    @Value("${routing-key.order-cancel-result.mc-spc-sales-service}")
    private String queueOrderCancelResultKey;

    public void sendOrderCreate(Order order) {

        logger.info("rabbitmq:sales发送订单创建请求：");
        logger.info(ObjectMapperUtil.getStringValue(order));
        rabbitTemplate.convertAndSend(exchangeOrder, queueOrderCreateKey, order);
    }

    public void sendOrderCancel(Order order) {

        logger.info("rabbitmq:sales发送订单取消请求：");
        logger.info(ObjectMapperUtil.getStringValue(order));
        rabbitTemplate.convertAndSend(exchangeOrder, queueOrderCancelKey, order);
    }
}
