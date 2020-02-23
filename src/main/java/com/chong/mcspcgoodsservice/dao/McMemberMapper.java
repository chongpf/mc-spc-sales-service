package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("mcMemberMapper")
public interface McMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(McMember record);

    McMember selectByPrimaryKey(Long id);

    List<McMember> selectAll();

    int updateByPrimaryKey(McMember record);
}