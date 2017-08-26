import com.jnshu.entity.Student;
import com.jnshu.service.Impl.StudentServiceImpl;
import com.jnshu.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * created by 姚远 on 2017/8/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})
public class ServiceTest {

    @Autowired
    private StudentService studentService;
    @Autowired
    ApplicationContext ctx;
    @Test
    public void test1(){
        Student student=studentService.selectById(3);
        System.out.println(student);
    }
    @Test
    public void test2(){
        Student student=new Student();
        student.setName("qwert");
        student.setQq(6466);
        student.setType("adsg");
        student.setTime(54654L);
        student.setSchool("wrge");
        student.setNumber(564);
        student.setLink("setry");
        student.setHope("aerg");
        student.setReferrer("wsedtaw");
        student.setFrom_where("erye");
        student.setId(34);
        student.setCreate_at(6464654L);
        student.setUpdate_at(5454L);
        studentService.studyUpdate(student);
    }
}
