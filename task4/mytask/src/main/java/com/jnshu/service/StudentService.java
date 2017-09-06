package com.jnshu.service;

import com.jnshu.entities.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by 姚远 on 2017/9/4.
 */
public interface StudentService {
    List<Student> studentAll();
//    int selectStudentNumber(@Param("studying") Integer studying);
    int selectStudentNumber(Integer studying);
}
