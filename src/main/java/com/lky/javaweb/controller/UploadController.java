package com.lky.javaweb.controller;

import com.lky.javaweb.pojo.Result;
import com.lky.javaweb.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws Exception{
//        log.info("file upload: {} {} {}", username, age, image);
//
//        //get raw filename
//        String originalFilename = image.getOriginalFilename();
//
//        //build unique filename with uuid
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFilename = UUID.randomUUID().toString() + extname;
//        log.info("new filename: {}", newFilename);
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("upload filename: {}", image.getOriginalFilename());

        //utilize aliyun to upload image to oss
        String url = aliOSSUtils.upload(image);
        log.info("upload complete, url for file access: {}", url);
        return Result.success(url);
    }
}
