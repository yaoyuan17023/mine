import model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest{
    public SqlSession getSession() throws IOException {
        String resource = "Configuration.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
    //selectStudent
    @Test
    public void selectStudent() throws IOException{
        SqlSession sqlSession = getSession();
        Student student = sqlSession.selectOne("HeMapper.selectStudent",1);
        System.out.println(student);
        sqlSession.close();
    }
    //selectList
    @Test
    public void getStudentListByName() throws IOException{
        SqlSession sqlSession = getSession();
        List<Student> list = sqlSession.selectList("HeMapper.getStudentListByName","test");
        //System.out.println(list);
        for(Student record1:list) {
            System.out.print("name :" + record1.getName());
            System.out.print(",qq :" + record1.getQq());
            System.out.print(",type :" + record1.getType());
            System.out.print(",time :" + record1.getTime());
            System.out.print(",school :" + record1.getSchool());
            System.out.print(",number :" + record1.getNumber());
            System.out.print(",link :" + record1.getLink());
            System.out.print(",hope :" + record1.getHope());
            System.out.print(",referrer :" + record1.getReferrer());
            System.out.print(",from :" + record1.getFrom());
            System.out.print(",id :" + record1.getId());
            System.out.print(",create_at :" + record1.getCreate_at());
            System.out.println(",update_at :" + record1.getUpdate_at());
        }
        sqlSession.close();
    }
    //insert
    @Test
    public void insertStudent() throws IOException{
        SqlSession sqlSession = getSession();
        Student student = new Student("father",123456,"java","2017-08-01","66",1111,
                "123","123","123","123",null,20170805,null);
        sqlSession.insert("HeMapper.insertStudent",student);
        sqlSession.commit();
        System.out.println(student.getId());
        sqlSession.close();
    }
    //delete
    @Test
    public void deleteStudent() throws  IOException{
        SqlSession sqlSession = getSession();
        sqlSession.delete("HeMapper.deleteStudent",7);
        sqlSession.commit();
        sqlSession.close();
    }
    //update
    @Test
    public void updateStudent() throws IOException{
        SqlSession sqlSession = getSession();
        Student student = new Student("jack",29,"java","2017-08-01","66",2173,
                "123","123","123","123",null,null,20170805);
        student.setId(4);
        sqlSession.update("HeMapper.updateStudent",student);
        sqlSession.commit();
        sqlSession.close();
    }
}