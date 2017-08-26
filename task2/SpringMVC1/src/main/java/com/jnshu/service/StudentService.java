package com.jnshu.service;

import com.jnshu.entity.Student;

import java.util.List;

/**
 * created by 姚远 on 2017/8/21.
 */
public interface StudentService {
    Student studySelect(String name);
    int studyInsert(Student student);
    int studyUpdate(Student student);
    int studyDelete(int id);
    Student selectById(int id);
    List<Student> studentAll();
}
