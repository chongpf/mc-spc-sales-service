package com.chong.mcspcgoodsservice.service;

import com.chong.common.entity.ResponseData;
import com.chong.common.util.ObjectMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiveOrderCuidResultQueueService {

    private static final Logger logger = LoggerFactory.getLogger(ReceiveOrderCuidResultQueueService.class);

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue("queue.order.create.result.mc-spc-sales-service"),
                    exchange = @Exchange("exchange.order"),
                    key = {"queue.order.create.result.mc-spc-sales-service"})
    })
    public void receiveOrderCreateResult(ResponseData responseData) {

        logger.info("rabbitmq:sales接收order的订单创建结果：");
        logger.info(ObjectMapperUtil.getStringValue(responseData));
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue("queue.order.cancel.result.mc-spc-sales-service"),
                    exchange = @Exchange("exchange.order"),
                    key = {"queue.order.cancel.result.mc-spc-sales-service"})
    })
    public void receiveOrderCancelResult(ResponseData responseData) {

        logger.info("rabbitmq:sales接收order的订单取消结果：");
        logger.info(ObjectMapperUtil.getStringValue(responseData));
    }
}
