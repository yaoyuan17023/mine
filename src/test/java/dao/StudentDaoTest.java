package dao;

import model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by codingBoy on 16/11/27.
 * 配置spring和junit整合，这样junit在启动时就会加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:Spring/spring-dao.xml"})
public class StudentDaoTest {
    //注入Dao实现类依赖
    @Resource
    private StudentDao studentDao;

    @Test
    public void getStudentList() throws Exception {
    }

    @Test
    public void insertStudent() throws Exception {
    }

    @Test
    public void updateStudent() throws Exception {
    }

    @Test
    public void deleteStudent() throws Exception {
    }

    @Test
    public void selectStudent() throws Exception {
        Student student = studentDao.selectStudent(9);
        System.out.println(student.getName());
        System.out.println(student);
    }

}