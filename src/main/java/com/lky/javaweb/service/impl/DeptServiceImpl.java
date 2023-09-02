package com.lky.javaweb.service.impl;

import com.lky.javaweb.mapper.DeptMapper;
import com.lky.javaweb.mapper.EmpMapper;
import com.lky.javaweb.pojo.Dept;
import com.lky.javaweb.pojo.DeptLog;
import com.lky.javaweb.service.DeptLogService;
import com.lky.javaweb.service.DeptService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list(){
        return deptMapper.list();
    }

    // no rollback will be executed for running exception
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) throws Exception{
        try {
            deptMapper.deleteById(id);
//            int i = 1/0;
            empMapper.deleteByDept(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("execute dept dismiss, delete dept"+id+"");
            deptLogService.insert(deptLog);
        }

    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept getById(Integer id) {return deptMapper.search(id);}

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
