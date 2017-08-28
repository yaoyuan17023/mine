package com.jnshu.controller;

import com.jnshu.entity.Student;
import com.jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * created by 姚远 on 2017/8/22.
 */
@Controller
public class Yayaya {
    private static Logger loggerController = Logger.getLogger(Yayaya.class);
    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id")Integer id,Model model){
        loggerController.info("按id查询学生信息");
        Student student=studentService.selectById(id);
        model.addAttribute("student",student);
        return "select";
    }

    //修改
    @RequestMapping(value = "/u/{id}",method = RequestMethod.GET)
    public String input(@PathVariable("id")Integer id,Model model){
        loggerController.info("修改学生信息");
        Student student=studentService.selectById(id);
        model.addAttribute("student",student);
        return "in";
    }
    @RequestMapping(value = "/u",method = RequestMethod.PUT,produces = "text/html;charset=UTF-8")
    public String update(Student student)throws Exception{
        studentService.studyUpdate(student);
        return "redirect:/student/list";
    }

    //删除
    @RequestMapping(value = "/d/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        loggerController.info("删除学生信息");
        studentService.studyDelete(id);
        return "redirect:/student/list";
    }

    //增加
    @RequestMapping(value = "/a/student",method = RequestMethod.POST)
    public String save(Student student){
        loggerController.info("增加学生信息");
        studentService.studyInsert(student);
        return "redirect:/student/list";
    }

    @RequestMapping(value = "/a/student",method = RequestMethod.GET)
    public String input(Map<String,Object>map){
        map.put("student",new Student());
        return "input";
    }


    //列表
    @RequestMapping("/student/list")
    public String list(Map<String,Object>map){
        loggerController.info("显示学生列表");
        map.put("students",studentService.studentAll());
        return "list";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public @ResponseBody List<Student> listStudents() {
        return studentService.studentAll();
    }
}
