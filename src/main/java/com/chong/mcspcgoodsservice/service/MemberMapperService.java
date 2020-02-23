package com.chong.mcspcgoodsservice.service;

import com.chong.common.idworker.IdWorker;
import com.chong.mcspcgoodsservice.dao.McMemberMapper;
import com.chong.mcspcgoodsservice.entity.McMember;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Service
public class MemberMapperService {

    @Autowired
    private McMemberMapper mcMemberMapper;

    @Autowired
    private IdWorker idWorker;

    public List<McMember> getMemberList() {
        return mcMemberMapper.selectAll();
    }

    public McMember getMember(Long id) {
        McMember optional = mcMemberMapper.selectByPrimaryKey(id);
        return optional;
    }

    public int insertMember(String name) {
        McMember member = newMember();
        if (StringUtils.isNotBlank(name)) {
            member.setName(name);
        }
        return mcMemberMapper.insert(member);
    }

    public int updateMember(Long id, String name) {
        McMember dbMember = getMember(id);
        if (dbMember != null) {
            dbMember.setName(name);
        }
        return mcMemberMapper.updateByPrimaryKey(dbMember);
    }

    public void deleteMember(Long id) {
        mcMemberMapper.deleteByPrimaryKey(id);
    }

    private McMember newMember() {
        int random = (new Random()).nextInt(1000);
        McMember member = new McMember();
        member.setId(idWorker.nextId());
        member.setAge(random % 100);
        member.setName("会员名" + random);
        member.setGender("" + ((random % 2) + 1));
        member.setIsDelete("0");
        member.setCreateTime(new Timestamp(System.currentTimeMillis()));
        member.setCreateUser((long) (random % 1000));
        return member;
    }
}
