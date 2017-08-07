import model.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MybatisUtil;

import java.util.List;

public class MybatisTest2 {
    @Test
    public void testGetStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串
         * HeMapper是Student.xml文件中mapper标签的namespace属性的值，
         * getAllStudent是select标签的id属性的值，通过select标签的id属性的值就可以找到要执行的SQL
         */
        String statement = "HeMapper.selectStudent";//映射sql的标识字符串
        //执行查找操作，将查询结果自动封装成List<Student>返回
        //List<Student> listStudent = sqlSession.selectList(statement);
        Student student = sqlSession.selectOne(statement,1);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(student);
    }
    @Test
    public void testDelete(){
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        String statement = "HeMapper.deleteStudent";
        int retResult = sqlSession.delete(statement,12);
        sqlSession.close();
        System.out.println(retResult);
    }
    @Test
    public void testAdd(){
        //SqlSession sqlSession = MyBatisUtil.getSqlSession(false);
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        String statement = "HeMapper.addStudent";//映射SQL的标识字符串
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
        //执行插入操作
        int retResult = sqlSession.insert(statement,student);
        //手动提交事务
        //sqlSession.commit();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        String statement = "HeMapper.updateStudent";//映射SQL的标识字符串
        Student student = new Student();
        student.setId(13);
        student.setName("什么鬼");
        student.setQq(789456123);
        student.setType("pm");
        student.setTime(2017731L);
        student.setSchool("哈佛");
        student.setNumber(2255);
        student.setLink("www.fuck.com");
        student.setHope("my life for aiur");
        student.setReferrer("老毛");
        student.setFromWhere("japan");
        student.setCreateAt(201785L);
        student.setUpdateAt(20170806L);
        //执行修改操作
        int retResult = sqlSession.update(statement,student);
        sqlSession.close();
        System.out.println(retResult);
    }
    @Test
    public void testGetAll(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        String statement = "HeMapper.getAllStudent";
        //执行查询操作，将查询结果自动封装成List<Student>返回
        List<Student> listStudent  = sqlSession.selectList(statement);
        sqlSession.close();
        System.out.println(listStudent);
    }
}
