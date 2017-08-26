package com.springmybatis.test;


import com.springmybatis.Mapper.StudentMapper;
import com.springmybatis.model.StudentMod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by 姚远 on 2017/8/15.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext-druid.xml");
        StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
        try{
            System.out.println("测试删除");
            int i = studentMapper.studyDelete("1");
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("测试查询");
            StudentMod studentMod=new StudentMod();
            studentMod.setName("yao");
            studentMod=studentMapper.studySelect(studentMod);
            System.out.println(studentMod);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("测试修改");
            StudentMod studentMod = new StudentMod();
            studentMod.setName("好难啊");
            studentMod.setUpdate_at(20170815L);
            studentMod.setId(9);
            int i =studentMapper.studyUpdate(studentMod);
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("测试增加");
            StudentMod studentMod = new StudentMod();
            studentMod.setName("全忘了啊");
            studentMod.setQq(283533685);
            studentMod.setType("pm");
            studentMod.setTime(20170814L);
            studentMod.setSchool("tianda");
            studentMod.setNumber(6516541);
            studentMod.setLink("sdsdfdf");
            studentMod.setHope("daydayup");
            studentMod.setReferrer("zhou");
            studentMod.setFrom_where("BeiJing");
            studentMod.setCreate_at(20170814L);
            studentMod.setUpdate_at(20170814L);
            studentMapper.studyInsert(studentMod);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("111");
        }
    }
}
