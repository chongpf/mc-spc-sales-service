package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McGoodsSkuTicket;

import java.util.List;

public interface McGoodsSkuTicketMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McGoodsSkuTicket record);

    McGoodsSkuTicket selectByPrimaryKey(Long id);

    List<McGoodsSkuTicket> selectAll();

    int updateByPrimaryKey(McGoodsSkuTicket record);
}