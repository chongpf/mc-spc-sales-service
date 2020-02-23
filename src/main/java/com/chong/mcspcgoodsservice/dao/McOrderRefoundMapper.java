package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McOrderRefound;

import java.util.List;

public interface McOrderRefoundMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McOrderRefound record);

    McOrderRefound selectByPrimaryKey(Long id);

    List<McOrderRefound> selectAll();

    int updateByPrimaryKey(McOrderRefound record);
}