package com.lky.javaweb.mapper;

import com.lky.javaweb.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//    @Select("select count(*) from emp")
//    public Long count();

//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);
    //  @Select("select * from emp")
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void deleteById(List<Integer> ids);

    @Insert("insert into emp(username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{password}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void add(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDept(Integer deptId);
}
