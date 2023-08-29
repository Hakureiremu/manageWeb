package com.lky.javaweb.controller;

import com.lky.javaweb.pojo.PageBean;
import com.lky.javaweb.pojo.Result;
import com.lky.javaweb.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    // search all records of employee
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("get emp info, page start:{} Size: {}", page, pageSize);
        PageBean pageBean= empService.page(page, pageSize);
        return Result.success(pageBean);
    }
}
