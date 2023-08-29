package com.lky.javaweb.service.impl;

import com.lky.javaweb.mapper.EmpMapper;
import com.lky.javaweb.pojo.Emp;
import com.lky.javaweb.pojo.PageBean;
import com.lky.javaweb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        Long count = empMapper.count();
        List<Emp> empList = empMapper.page((page-1)*pageSize, pageSize);
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }
}
