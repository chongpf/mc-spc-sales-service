package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McGoodsSkuPackageTicket;

import java.util.List;

public interface McGoodsSkuPackageTicketMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McGoodsSkuPackageTicket record);

    McGoodsSkuPackageTicket selectByPrimaryKey(Long id);

    List<McGoodsSkuPackageTicket> selectAll();

    int updateByPrimaryKey(McGoodsSkuPackageTicket record);
}