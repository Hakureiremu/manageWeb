package com.lky.javaweb.service;

import com.lky.javaweb.pojo.Dept;

import java.util.List;

public interface DeptService {
    // search for department info
    List<Dept> list();

    // delete department
    void delete(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);

//    // add department
//    void add(Dept dept);
}
