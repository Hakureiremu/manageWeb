package com.lky.javaweb.service;

import com.lky.javaweb.pojo.Emp;
import com.lky.javaweb.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;


public interface EmpService {
    //paging query(all)
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
    //dynamic delete
    void delete(List<Integer> ids);
    //add an employer
    void add(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);
}
