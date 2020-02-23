package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McOrder;

import java.util.List;

public interface McOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McOrder record);

    McOrder selectByPrimaryKey(Long id);

    List<McOrder> selectAll();

    int updateByPrimaryKey(McOrder record);
}