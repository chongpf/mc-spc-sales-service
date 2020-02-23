package com.chong.mcspcgoodsservice.service;

import com.chong.mcspcgoodsservice.dto.GoodsCardDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品卡的业务处理
 */
@Service
public class GoodsCardCacheService {
    private static final Logger logger = LoggerFactory.getLogger(GoodsCardCacheService.class);

    @Cacheable(value = "goodsCardList")
    public List<GoodsCardDto> getGoodsCardList() {
        logger.info("method run:" + "getGoodsCardList" + "with cacheable:goodsCardList" + " count:" + 10);
        return initGoodsCardDtoList(10);
    }

    @Cacheable(value = "goodsCard", key = "#index")
    public GoodsCardDto getGoodsCard(int index) {
        logger.info("method run:" + "getGoodsCard" + "with cacheable:goodsCard" + " index:" + index);
        return initGoodsCardDto(index);
    }

    @CachePut(value = "goodsCard", key = "#result.mcGoods.id")
    public GoodsCardDto addGoodsCard(int index) {
        logger.info("method run:" + "addGoodsCard" + "with CachePut:goodsCard" + " index:" + index);
        return initGoodsCardDto(index);
    }
    @CachePut(value = "goodsCard", key = "#result.mcGoods.id")
    public GoodsCardDto updateGoodsCard(int index) {
        logger.info("method run:" + "addGoodsCard" + "with CachePut:goodsCard" + " index:" + index);
        GoodsCardDto dto = initGoodsCardDto(index);
        dto.getMcGoods().setGoodsName("update goods name is ok");
        return dto;
    }
    @CacheEvict(value = "goodsCard", key = "#index")
    public void deleteGoodsCard(int index) {
        logger.info("method run:" + "deleteGoodsCard" + "with CacheEvict:goodsCard" + " index:" + index);
        // del from the db
    }

    private GoodsCardDto initGoodsCardDto(int index) {
        GoodsCardDto goodsCardDto = new GoodsCardDto();
        // 设置基础商品信息
        goodsCardDto.getMcGoods().setId(Long.valueOf(""+index));
        goodsCardDto.getMcGoodsSku().setId(Long.valueOf(""+(index+1000)));
        goodsCardDto.getMcGoodsSkuCard().setId(Long.valueOf(""+(index+10000)));
        return goodsCardDto;
    }

    private List<GoodsCardDto> initGoodsCardDtoList(int count) {
        List<GoodsCardDto> goodsCardDtoList = new ArrayList<>(count);
        for (int i = 1; i <= count; i++) {
            goodsCardDtoList.add(initGoodsCardDto(i));
        }
        return goodsCardDtoList;
    }
}
