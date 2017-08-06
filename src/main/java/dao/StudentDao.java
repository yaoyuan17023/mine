package dao;

import model.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> getStudentList();
    public void insertStudent(Student HeMapper);
    public void updateStudent(Student HeMapper);
    public void deleteStudent(int Id);
    public Student selectStudent(int id);
}
