package com.lky.javaweb.controller;

import com.lky.javaweb.pojo.Emp;
import com.lky.javaweb.pojo.PageBean;
import com.lky.javaweb.pojo.Result;
import com.lky.javaweb.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    // dynamic query of employee
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("get emp info, page start:{} Size: {}", page, pageSize);
        PageBean pageBean= empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    // dynamic delete of employee
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("delete employee according to id:" + ids);
        empService.delete(ids);
        return Result.success();
    }

    // add employer with avatar image
    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("add employer:{}", emp);
        empService.add(emp);
        return Result.success();
    }

    // modify an employer, show message first
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("get info of emp according to id: {}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    // modify an employer
    @PutMapping
    public Result put(@RequestBody Emp emp){
        log.info("modify emp record to:{}", emp);
        empService.update(emp);
        return Result.success();
    }

}
