package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McCheckinManagetment;

import java.util.List;

public interface McCheckinManagetmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McCheckinManagetment record);

    McCheckinManagetment selectByPrimaryKey(Long id);

    List<McCheckinManagetment> selectAll();

    int updateByPrimaryKey(McCheckinManagetment record);
}