package com.lky.javaweb.controller;

import com.lky.javaweb.pojo.Dept;
import com.lky.javaweb.pojo.Result;
import com.lky.javaweb.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    // search dept info
    @GetMapping
    public Result list(){
        log.info("search data of all departments");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("delete department according to id:" + id);
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("add new dept: {}", dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result search(@PathVariable Integer id){
        log.info("search department data according to id:{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("update a dept: {}", dept);
        deptService.update(dept);
        return Result.success();
    }


}
