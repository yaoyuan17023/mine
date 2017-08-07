package implement;

/**
 * created by 姚远 on 2017/8/7.
 * 使用@Service注解将StudentServiceImpl类标注为一个service
 * service的id是studentService
 */

import dao.StudentDao;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.StudentService1;

@Service("studentService")
public class StudentServiceImpl implements StudentService1{

    /**
     * 使用@Autowired注解标注studentDao变量，
     * 当需要使用StudentDao时，Spring就会自动注入StudentDao
     */
    @Autowired
    private StudentDao studentDao;//注入dao

    @Override
    public void addStudent(Student student){
        studentDao.studentInsert(student);
    }

    @Override
    public Student getStudentById(int id){
        return studentDao.studentSelect(id);
    }
}