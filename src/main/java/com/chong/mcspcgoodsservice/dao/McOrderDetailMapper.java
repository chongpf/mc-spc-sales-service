package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McOrderDetail;

import java.util.List;

public interface McOrderDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McOrderDetail record);

    McOrderDetail selectByPrimaryKey(Long id);

    List<McOrderDetail> selectAll();

    int updateByPrimaryKey(McOrderDetail record);
}