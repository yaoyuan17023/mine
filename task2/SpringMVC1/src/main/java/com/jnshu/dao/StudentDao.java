package com.jnshu.dao;

import com.jnshu.entity.Student;

import java.util.List;

/**
 * created by 姚远 on 2017/8/21.
 */
public interface StudentDao {
    Student selectById(int id);
    Student studySelect(String name);
    int studyInsert(Student student);
    int studyUpdate(Student student);
    int studyDelete(int id);
    List<Student> studentAll();
}
