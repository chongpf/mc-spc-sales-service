package com.chong.mcspcgoodsservice.RemoteCall.Order;

import com.chong.common.entity.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="mc-spc-order-service",fallback = OrderRemoteClientFallback.class)
public interface OrderRemoteClient {

    @GetMapping(value="/order/{orderId}")
    ResponseData getOrder(@PathVariable("orderId") String orderId);

}