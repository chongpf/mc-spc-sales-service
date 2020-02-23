package com.chong.mcspcgoodsservice.controller;

import com.chong.common.entity.ResponseData;
import com.chong.common.util.ResponseUtil;
import com.chong.mcspcgoodsservice.entity.McMember;
import com.chong.mcspcgoodsservice.service.CustMemberUseMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/customize/mapper/member")
public class TestCustumizeMapperController {

    @Autowired
    private CustMemberUseMapperService service;

    @GetMapping("/list")
    public ResponseData getAll() {
        return ResponseUtil.success(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseData getOne(@PathVariable("id") Long id) {
        McMember member = service.getOne(id);
        return ResponseUtil.success(member);
    }

    @DeleteMapping("/{id}")
    public ResponseData deleteOne(@PathVariable("id") Long id) {
        return ResponseUtil.success(service.deleteOne(id));
    }

    @PostMapping("/{id}")
    public ResponseData insertOne(@PathVariable("id") Long id) {
        return ResponseUtil.success(service.insertOne(id));
    }

    @PutMapping("/{id}/{name}")
    public ResponseData updateOne(@PathVariable("id") Long id, @PathVariable("name") String name) {
        return ResponseUtil.success(service.updateOne(id, name));
    }
}
