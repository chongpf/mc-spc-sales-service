package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McSalesGoodsPackageRelation;

import java.util.List;

public interface McSalesGoodsPackageRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McSalesGoodsPackageRelation record);

    McSalesGoodsPackageRelation selectByPrimaryKey(Long id);

    List<McSalesGoodsPackageRelation> selectAll();

    int updateByPrimaryKey(McSalesGoodsPackageRelation record);
}