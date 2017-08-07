import model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class CommonTest {
    public static void main(String[] args) throws IOException {
        //mybatis配置文件
        String resource = "configuration.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = CommonTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用Mybatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的表示字符串，
         * HeMapper是Student.xml文件中mapper标签的namespace属性的值，
         * selectStudent是select标签下的id属性的值，通过select标签的id属性值就可以找到要执行的sql
         */
        String statement = "HeMapper.selectStudent";//映射sql的标识字符串
        //执行查询返回一个唯一student对象的sql
        Student student = session.selectOne(statement,2);

        System.out.println(student);
    }
}
