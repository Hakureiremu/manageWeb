package com.lky.javaweb.service;

import com.lky.javaweb.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface EmpService {
    //paging query(all)
    PageBean page(Integer page, Integer pageSize);

}
