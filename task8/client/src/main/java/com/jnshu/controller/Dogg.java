package com.jnshu.controller;

import com.jnshu.entities.Student;
import com.jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * created by 姚远 on 2017/9/4.
 */
@Controller
public class Dogg {
    private static Logger logger=Logger.getLogger(Dogg.class);
    //显示所有学生列表
    @RequestMapping(value="/home",method =RequestMethod.GET)
//    public String All(Model model){
//        List<Student> studentList=null;
//        ApplicationContext context=new ClassPathXmlApplicationContext("spring/client1.xml");
//        StudentService studentService= (StudentService) context.getBean("StudentService");
//        studentList=studentService.studentAll();
//        model.addAttribute("studentList",studentList);
//        return "list";
//    }
    public String showStudent(Model model) {
        logger.info("查询所有用户信息");
        List<Student> studentList = null;
        double m = Math.random();
        int rr = (int) (m * 10);
        System.out.println("产生随机数是：" + rr);
        if (rr % 2 != 0) {
            try {
                ApplicationContext ctx = new ClassPathXmlApplicationContext(
                        "spring/client1.xml");
                StudentService studentService = (StudentService) ctx.getBean("StudentService");
                studentList = studentService.studentAll();
                logger.info("访问server1");
            } catch (BeanCreationException e) {
                ApplicationContext ctx = new ClassPathXmlApplicationContext(
                        "spring/client2.xml");
                StudentService studentService = (StudentService) ctx.getBean("StudentService");
                studentList = studentService.studentAll();
                logger.info("访问server1失败，访问server2");
            }
        } else {
            try {
                ApplicationContext ctx = new ClassPathXmlApplicationContext(
                        "spring/client2.xml");
                StudentService studentService = (StudentService) ctx.getBean("StudentService");
                studentList = studentService.studentAll();
                logger.info("访问server2");
            } catch (BeanCreationException e) {
                ApplicationContext ctx = new ClassPathXmlApplicationContext(
                        "spring/client1.xml");
                StudentService studentService = (StudentService) ctx.getBean("StudentService");
                studentList = studentService.studentAll();
                logger.info("访问server2失败，访问server1");
            }
        }model.addAttribute("studentList",studentList);
        return "list";

    }
}
