package com.chong.mcspcgoodsservice.controller;

import com.chong.common.entity.ResponseData;
import com.chong.common.util.ResponseUtil;
import com.chong.mcspcgoodsservice.service.GoodsCardCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/goodscard")
public class TestCardGoodsCacheController {
  @Autowired
  private GoodsCardCacheService goodsCardService;

  private static final Logger logger = LoggerFactory.getLogger(TestCardGoodsCacheController.class);

  @GetMapping("/list")
  public ResponseData getCardGoodsList(){
      return ResponseUtil.success(goodsCardService.getGoodsCardList());
  }
  @GetMapping("/{index}")
  public ResponseData getCardGoods(@PathVariable("index") int index){
    return ResponseUtil.success(goodsCardService.getGoodsCard(index));
  }
  @PostMapping("/{index}")
  public ResponseData addCardGoods(@PathVariable("index") int index){
    return ResponseUtil.success(goodsCardService.addGoodsCard(index));
  }
  @PutMapping("/{index}")
  public ResponseData updateCardGoods(@PathVariable("index") int index){
    return ResponseUtil.success(goodsCardService.addGoodsCard(index));
  }
  @DeleteMapping("/{index}")
  public ResponseData deleteCardGoods(@PathVariable("index") int index){
    goodsCardService.deleteGoodsCard(index);
    return ResponseUtil.success(index);
  }
//  @GetMapping("/testGetAll")
//  public ResponseData testGetALl(){
//    getCardGoodsList();
//    return ResponseUtil.success("testGetALL is ok");
//  }
//
//  @GetMapping("/testGetAfterGet")
//  public ResponseData testGetAfterGet(){
//    getCardGoodsList()
//    return ResponseUtil.success("testGetALL is ok");
//  }
}
