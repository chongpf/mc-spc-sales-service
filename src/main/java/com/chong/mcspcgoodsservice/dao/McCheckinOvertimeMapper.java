package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McCheckinOvertime;

import java.util.List;

public interface McCheckinOvertimeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McCheckinOvertime record);

    McCheckinOvertime selectByPrimaryKey(Long id);

    List<McCheckinOvertime> selectAll();

    int updateByPrimaryKey(McCheckinOvertime record);
}