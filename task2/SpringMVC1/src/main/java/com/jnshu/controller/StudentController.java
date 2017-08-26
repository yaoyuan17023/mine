//package com.jnshu.controller;
//
//import com.jnshu.entity.Student;
//import com.jnshu.service.StudentService;
//import com.sun.xml.internal.xsom.impl.scd.Iterators;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.io.IOException;
//
///**
// * created by 姚远 on 2017/8/21.
// */
//@Controller
////@RequestMapping("/select")
//public class StudentController {
//    @Autowired
//    private StudentService studentService;
//    @RequestMapping(value = "/select/{id}",method = RequestMethod.GET)
//    public String in(@PathVariable("id") int id, Model model) {
//        Student student = studentService.selectById(id);
//
//        System.out.println(student);
//
//        model.addAttribute("student", student);
//        return "select";
//    }
//
//    @RequestMapping(value = "/test",method = RequestMethod.GET)
//    public String tees(){
//        return "test";
//    }
//
//    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
//    public String update(Student student, @PathVariable("id") Integer id) throws IOException {
//        studentService.studyUpdate(student);
//        return "update";
//    }
//
//
//
//}
