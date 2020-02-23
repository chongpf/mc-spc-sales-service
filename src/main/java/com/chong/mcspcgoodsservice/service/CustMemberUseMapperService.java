package com.chong.mcspcgoodsservice.service;

import com.chong.mcspcgoodsservice.dao.CustMemberMapper;
import com.chong.mcspcgoodsservice.entity.McMember;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustMemberUseMapperService {

    @Autowired
    private CustMemberMapper custMemberMapper;

    public List<McMember> getAll() {
        return custMemberMapper.selectAll();
    }

    public McMember getOne(Long id) {
        return custMemberMapper.selectOne(id);
    }

    public int deleteOne(Long id) {
        return custMemberMapper.deleteOne(id);
    }

    public int insertOne(Long id) {
        McMember mcMember = newMember();
        mcMember.setId(id);
        return custMemberMapper.insertOne(mcMember);
    }

    public int updateOne(Long id, String name) {
        McMember mcMember = this.custMemberMapper.selectOne(id);
        if (mcMember != null) {
            mcMember.setName(name);
            Map hashMap = new HashMap();
            BeanMap beanMap = BeanMap.create(mcMember);
            for (Object key : beanMap.keySet()) {
                hashMap.put(key, beanMap.get(key));
            }
            return this.custMemberMapper.updateOne(hashMap);
        }
        return 0;
    }

    private McMember newMember() {
        McMember mcMember = new McMember();
        int rand = RandomUtils.nextInt(10000);
        mcMember.setName("name:" + rand);
        mcMember.setAge(rand % 100);
        mcMember.setGender(rand % 2 + "");
        mcMember.setIsDelete("0");
        mcMember.setCreateUser(Long.valueOf((rand+100)+""));
        return mcMember;
    }

}
