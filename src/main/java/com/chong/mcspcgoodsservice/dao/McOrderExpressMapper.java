package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McOrderExpress;

import java.util.List;

public interface McOrderExpressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McOrderExpress record);

    McOrderExpress selectByPrimaryKey(Long id);

    List<McOrderExpress> selectAll();

    int updateByPrimaryKey(McOrderExpress record);
}