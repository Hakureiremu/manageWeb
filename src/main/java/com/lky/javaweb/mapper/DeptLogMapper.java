package com.lky.javaweb.mapper;

import com.lky.javaweb.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
    @Insert("insert into demanagement.dept_log(create_time,description) values(#{createTime},#{description})")
    void insert(DeptLog log);
}
