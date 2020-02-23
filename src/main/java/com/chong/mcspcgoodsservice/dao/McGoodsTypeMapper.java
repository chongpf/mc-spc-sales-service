package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McGoodsType;

import java.util.List;

public interface McGoodsTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McGoodsType record);

    McGoodsType selectByPrimaryKey(Long id);

    List<McGoodsType> selectAll();

    int updateByPrimaryKey(McGoodsType record);
}