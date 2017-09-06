package com.jnshu.dao;

import com.jnshu.entities.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> studentAll();

    int selectStudentNumber(@Param("studying") Integer studying);
//    int selectStudentNumber(Integer studying);
}