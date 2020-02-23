package com.chong.mcspcgoodsservice.controller;

import com.chong.common.entity.ResponseData;
import com.chong.common.util.ResponseUtil;
import com.chong.mcspcgoodsservice.service.MemberRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/repo/member")
public class TestMemberRepositoryController {

    @Autowired
    private MemberRepositoryService memberService;

    @GetMapping("/list")
    public ResponseData getAllMembers() {
        return ResponseUtil.success(memberService.getMemberList());
    }

    @GetMapping("/{id}")
    public ResponseData getMember(@PathVariable("id") Long id) {
        return ResponseUtil.success(memberService.getMember(id));
    }

    @PostMapping("/{name}")
    public ResponseData addMember(@PathVariable("name") String name) {
        return ResponseUtil.success(memberService.saveMember(name));
    }

    @DeleteMapping("/{id}")
    public ResponseData addMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
        return ResponseUtil.success("delete success:" + id);
    }
}
