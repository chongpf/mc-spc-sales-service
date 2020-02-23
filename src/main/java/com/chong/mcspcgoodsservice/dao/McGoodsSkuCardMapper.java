package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McGoodsSkuCard;

import java.util.List;

public interface McGoodsSkuCardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McGoodsSkuCard record);

    McGoodsSkuCard selectByPrimaryKey(Long id);

    List<McGoodsSkuCard> selectAll();

    int updateByPrimaryKey(McGoodsSkuCard record);
}