package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McSalesGoods;

import java.util.List;

public interface McSalesGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McSalesGoods record);

    McSalesGoods selectByPrimaryKey(Long id);

    List<McSalesGoods> selectAll();

    int updateByPrimaryKey(McSalesGoods record);
}