package task1.Utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * created by 姚远 on 2017/8/15.
 */
public class MybatisUtil {
    public static SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatisConf.xml";
        InputStream is = MybatisUtil.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        return factory;
    }
    public static SqlSession getSqlSession(){
        return getSqlSessionFactory().openSession();
    }
    public static SqlSession getSqlSession(boolean isAutoCommit) {
        return getSqlSessionFactory().openSession(isAutoCommit);
    }
}
