import com.jnshu.dao.StudentDao;
import com.jnshu.entity.Student;
import junit.framework.JUnit4TestAdapterCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * created by 姚远 on 2017/8/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})
public class test {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    ApplicationContext ctx;


    @Test
    public void testSelect(){
        Student student = studentDao.selectById(2);
        System.out.println(student);
    }

    @Test
    public void test2(){
        Student student=new Student();
        student.setId(2);
        student.setName("wet");
        student.setUpdate_at(654654L);
        studentDao.studyUpdate(student);
    }

}
