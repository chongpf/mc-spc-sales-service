package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McGoodsSku;

import java.util.List;

public interface McGoodsSkuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McGoodsSku record);

    McGoodsSku selectByPrimaryKey(Long id);

    List<McGoodsSku> selectAll();

    int updateByPrimaryKey(McGoodsSku record);
}