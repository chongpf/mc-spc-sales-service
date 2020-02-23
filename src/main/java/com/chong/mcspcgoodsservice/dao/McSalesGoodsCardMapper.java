package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McSalesGoodsCard;

import java.util.List;

public interface McSalesGoodsCardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McSalesGoodsCard record);

    McSalesGoodsCard selectByPrimaryKey(Long id);

    List<McSalesGoodsCard> selectAll();

    int updateByPrimaryKey(McSalesGoodsCard record);
}