package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McSalesGoodsTicket;

import java.util.List;

public interface McSalesGoodsTicketMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McSalesGoodsTicket record);

    McSalesGoodsTicket selectByPrimaryKey(Long id);

    List<McSalesGoodsTicket> selectAll();

    int updateByPrimaryKey(McSalesGoodsTicket record);
}