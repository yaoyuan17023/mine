package com.springmybatis.test;

import com.springmybatis.Mapper.StudentMapper;
import com.springmybatis.model.StudentMod;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * created by 姚远 on 2017/8/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext-druid.xml"})
public class StudentMapperTest {
    private static Logger loggerTest = Logger.getLogger(Test.class);

    //对ctx进行标注，完成自动配装的工作
    @Autowired
    ApplicationContext  ctx;

    //所有测试开始前执行
    @BeforeClass
    public static void begin(){
        loggerTest.info("测试开始");
    }

    //所有测试完成后执行
    @AfterClass
    public static void end(){
        loggerTest.info("测试结束");
    }

    @Test
    public void studentDelete(){
        try {
            loggerTest.info("测试删除");
            StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
            //i为返回影响的行数
            int i = studentMapper.studyDelete("19");
            loggerTest.info("删除记录： " + i);
        }catch (Exception e){
            e.printStackTrace();
            loggerTest.error("删除出错： " + e.getMessage());
        }
    }
    @Test
    public void studentSelect(){
        try {
            loggerTest.info("测试查找\n");
            //getBean() 方法得到所需要的 bean
            StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
            StudentMod studentMod = new StudentMod();
            studentMod.setName("yao");
            studentMod = studentMapper.studySelect(studentMod);
            loggerTest.info("输出查询结果\n" + studentMod);
        }
        catch (Exception e){
            e.printStackTrace();
            loggerTest.error("查找出错："+e.getMessage());
        }
    }
    @Test
    public void studentInsert(){
        try {
            loggerTest.info("测试增加");
            StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
            StudentMod studentMod1 = new StudentMod();
            studentMod1.StudentMod("张三丰",28555,"JAVA",20170809L,"qinghua",2140,"www.NMB.com","life","sb","yuzhou",18,20170809L,20170809L);
            studentMapper.studyInsert(studentMod1);
        }catch (Exception e){
            e.printStackTrace();
            loggerTest.error("增加出错： " + e.getMessage());
        }
    }
    @Test
    public void studentUpdate(){
        try {
            loggerTest.info("测试更改");
            StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
            StudentMod studentMod4 = new StudentMod();
            studentMod4.setName("阿尔萨斯");
            studentMod4.setUpdate_at(20170809L);
            studentMod4.setId(9);
            //i为返回影响的行数
            int i = studentMapper.studyUpdate(studentMod4);
            loggerTest.info("修改记录： " + i);
        }catch (Exception e){
            e.printStackTrace();
            loggerTest.error("修改出错： " + e.getMessage());
        }
    }

    @Ignore
    @Test
    public void ignore(){
        loggerTest.info("忽略该测试");
    }
}
