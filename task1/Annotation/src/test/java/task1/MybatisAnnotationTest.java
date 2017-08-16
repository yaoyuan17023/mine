package task1;

import task1.beans.AdminInfo;
import task1.dataaccess.IAdminInfoMapper;
import task1.Utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * created by 姚远 on 2017/8/15.
 */
public class MybatisAnnotationTest {
    @Test
    public void testSelect(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        IAdminInfoMapper mapper=sqlSession.getMapper(IAdminInfoMapper.class);
        AdminInfo student = mapper.selectById(8);
        sqlSession.close();
        System.out.println(student);
    }
    @Test
    public void testAdd(){
        SqlSession sqlSession =MybatisUtil.getSqlSession(true);
        IAdminInfoMapper mapper=sqlSession.getMapper(IAdminInfoMapper.class);
        AdminInfo student = new AdminInfo();
        student.setName("注释加入");
        student.setQq(111555999);
        student.setType("QA");
        student.setTime(20170815L);
        student.setSchool("putteng");
        student.setNumber(2048);
        student.setLink("www.baidu.com");
        student.setHope("killall");
        student.setReferrer("Obama");
        student.setFrom_where("知乎");
        student.setCreate_at(20170815L);
        student.setUpdate_at(20170815L);
        int add = mapper.add(student);
        sqlSession.close();
        System.out.println(add);
    }
    @Test
    public void testDelete(){
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);
        int retResult = mapper.deleteById(20);
        sqlSession.close();
        System.out.println(retResult);
    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);
        AdminInfo student = new AdminInfo();
        student.setName("车太闷");
        student.setUpdate_at(20170815L);
        int retResult = mapper.updateById(18);
        sqlSession.close();
        System.out.println(retResult);
    }
    @Test
    public void testGetAll(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);
        List<AdminInfo> all = mapper.getAll();
        sqlSession.close();
        System.out.println(all);
    }

}
