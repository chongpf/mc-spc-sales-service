package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McMaster;

import java.util.List;

public interface McMasterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(McMaster record);

    McMaster selectByPrimaryKey(Integer id);

    List<McMaster> selectAll();

    int updateByPrimaryKey(McMaster record);
}