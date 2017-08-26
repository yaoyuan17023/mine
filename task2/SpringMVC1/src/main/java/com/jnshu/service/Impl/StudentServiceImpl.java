package com.jnshu.service.Impl;

import com.jnshu.dao.StudentDao;
import com.jnshu.entity.Student;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by 姚远 on 2017/8/21.
 */
@Service
public class StudentServiceImpl implements StudentService  {
    @Autowired
    private StudentDao studentDao;

    public Student studySelect(String name) {
        Student student1=studentDao.studySelect(name);
        return student1;
    }

    public int studyInsert(Student student) {
        int i = studentDao.studyInsert(student);
        return i;
    }

    public int studyUpdate(Student student) {
        int i = studentDao.studyUpdate(student);
        return i;
    }

    public int studyDelete(int id) {
        int i = studentDao.studyDelete(id);
        return i;
    }
    public Student selectById(int id){
        Student student = studentDao.selectById(id);
        return student;
    }
    public List<Student> studentAll(){
        List<Student> study=this.studentDao.studentAll();
        return study;
    }
}
