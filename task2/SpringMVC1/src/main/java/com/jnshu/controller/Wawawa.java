//package com.jnshu.controller;
//
//import com.jnshu.entity.Student;
//import com.jnshu.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * created by 姚远 on 2017/8/21.
// */
//@Controller
//@RequestMapping("/student")
//public class Wawawa {
//    @Autowired
//    private StudentService studentService;
//    private final static Map<String, Student> students = new HashMap<String, Student>();
//
////    @RequestMapping(value = "/add", method = RequestMethod.GET)
////    public String addStudent(Model model) {
////        model.addAttribute(new Student());
////        return "add";
////    }
//
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String addStudent(Student student) {
//        students.put(student.getName(), student);
//        return "select";
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable("id") Integer id) {
//        studentService.studyDelete(id);
//        return "delete";
//    }
//}
////    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
////    public String delete(@PathVariable String id) {
////        students.remove(id);
////       return "delete"; //删除完成后显示当前存在的所有用户信息
////    }
////
////    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
////    public String show(@PathVariable("id") int id, Model model) {
////        studentService.selectById(id);
////        model.addAttribute("student",students);
////        return "list";
////    }
////}
