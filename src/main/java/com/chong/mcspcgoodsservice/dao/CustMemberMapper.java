package com.chong.mcspcgoodsservice.dao;

import com.chong.mcspcgoodsservice.entity.McMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Component("custMemberMapper")
public interface CustMemberMapper {

    List<McMember> selectAll();

    McMember selectOne(@Param("id") Long id);

    int deleteOne(@Param("id") Long id);

    int insertOne(McMember member);

    int updateOne(Map member);
}
