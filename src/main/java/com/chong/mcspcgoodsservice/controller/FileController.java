package com.chong.mcspcgoodsservice.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {

    @PostMapping("/file/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        File saveFile = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes,saveFile);
        return  saveFile.getAbsolutePath();
    }
}
