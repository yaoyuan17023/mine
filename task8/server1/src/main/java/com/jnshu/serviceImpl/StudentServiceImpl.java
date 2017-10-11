package com.jnshu.serviceImpl;

import com.jnshu.dao.StudentMapper;
import com.jnshu.entities.Student;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by 姚远 on 2017/9/4.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> studentAll() {
        List<Student> students = studentMapper.studentAll();
        for (Student student:students){
            System.out.println(student);
        }
        return students;
    }
    public int selectStudentNumber(Integer studying){
        int i = studentMapper.selectStudentNumber(studying);
        return i;
    }
}



