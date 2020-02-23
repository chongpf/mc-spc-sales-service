package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McGoodsSkuParam;

import java.util.List;

public interface McGoodsSkuParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McGoodsSkuParam record);

    McGoodsSkuParam selectByPrimaryKey(Long id);

    List<McGoodsSkuParam> selectAll();

    int updateByPrimaryKey(McGoodsSkuParam record);
}