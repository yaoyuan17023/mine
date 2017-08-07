package dao;

import model.Student;

import java.util.List;

/**
 * 定义增删改查的接口
 */
public interface StudentDao {
    Student studentSelect(int id);
    int studentInsert(Student student);
    int studentUpdate(Student student);
    int studentDelete(int id);
    List<Student> studentName();
}
