package service;

import model.Student;

/**
 * created by 姚远 on 2017/8/7.
 */
public interface StudentService1 {
    /**
     * 添加用户
     * @param student
     */
    void addStudent(Student student);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    Student getStudentById(int id);

}
