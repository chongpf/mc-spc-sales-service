package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McCardBizHistory;

import java.util.List;

public interface McCardBizHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McCardBizHistory record);

    McCardBizHistory selectByPrimaryKey(Long id);

    List<McCardBizHistory> selectAll();

    int updateByPrimaryKey(McCardBizHistory record);
}