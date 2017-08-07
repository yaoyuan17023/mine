import model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.StudentService1;

import javax.swing.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class MybatisTest{
    @Autowired
    private StudentService1 studentService;
    @Test
    public void testAddStudent(){
        Student student = new Student();
        student.setName("yao");
        student.setQq(123);
        student.setType("java");
        student.setTime(20170805L);
        student.setSchool("123");
        student.setNumber(4645);
        student.setLink("sdfsd");
        student.setHope("sdfsdf");
        student.setReferrer("zhou");
        student.setFromWhere("beijing");
        student.setCreateAt(20170805L);
        student.setUpdateAt(20170807L);
        studentService.addStudent(student);
    }
}