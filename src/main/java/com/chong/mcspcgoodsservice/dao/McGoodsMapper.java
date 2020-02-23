package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McGoods;

import java.util.List;

public interface McGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McGoods record);

    McGoods selectByPrimaryKey(Long id);

    List<McGoods> selectAll();

    int updateByPrimaryKey(McGoods record);
}