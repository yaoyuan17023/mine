package com.jnshu.controller;

import com.jnshu.entity.Student;
import com.jnshu.service.StudentService;
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
    @Autowired
    private StudentService studentService;

    //修改
    @RequestMapping(value = "/a/student/update/{id}",method = RequestMethod.GET)
    public String input(@PathVariable("id")Integer id,Model model){
        Student student=studentService.selectById(id);
        model.addAttribute("student",student);
        return "in";
    }
    @RequestMapping(value = "/a/student/update",method = RequestMethod.PUT,produces = "text/html;charset=UTF-8")
    public String update(Student student)throws Exception{
        studentService.studyUpdate(student);
        return "redirect:/a/student/all";
    }

    //删除
    @RequestMapping(value = "/a/student/delete/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        studentService.studyDelete(id);
        return "redirect:/a/student/all";
    }

    //增加
    @RequestMapping(value = "/a/student/insert",method = RequestMethod.POST)
    public String save(Student student){
        studentService.studyInsert(student);
        return "redirect:/a/student/all";
    }

    @RequestMapping(value = "/a/student/insert",method = RequestMethod.GET)
    public String input(Map<String,Object>map){
        map.put("student",new Student());
        return "input";
    }


    //列表
    @RequestMapping("/a/student/all")
    public String list(Map<String,Object>map){
        map.put("students",studentService.studentAll());
        return "list";
    }
//    @ResponseBody
//    @RequestMapping("/getStudents")
//    public List<Student> testJson(){
//        return studentService.studentAll();
//    }
}
