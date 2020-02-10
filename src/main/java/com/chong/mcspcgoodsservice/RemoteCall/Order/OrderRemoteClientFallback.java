package com.chong.mcspcgoodsservice.RemoteCall.Order;

import com.chong.common.entity.ResponseData;
import com.chong.common.util.ResponseUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class OrderRemoteClientFallback implements OrderRemoteClient{

    @Override
    public ResponseData getOrder(String orderId){
        return ResponseUtil.fail(1002,"feignHystrixFallback");
    }

}