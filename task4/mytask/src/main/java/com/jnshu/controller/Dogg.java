package com.jnshu.controller;

import com.jnshu.entities.Profession;
import com.jnshu.entities.Student;
import com.jnshu.service.ProfessionService;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * created by 姚远 on 2017/9/4.
 */
@Controller
public class Dogg {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ProfessionService professionService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String getAll(Model model){
        int working = studentService.selectStudentNumber(0);
        int total = studentService.selectStudentNumber(null);
        List<Student> students=studentService.studentAll();
        model.addAttribute("working",working);
        model.addAttribute("total",total);
        model.addAttribute("students",students);
        return "t10";
    }

    @RequestMapping(value = "/job",method = RequestMethod.GET)
    public String professionAll(Model model){
        int java =professionService.selectNumber(1);
        int css =professionService.selectNumber(2);
        List<Profession> professions=professionService.selectProfessionAll();
        List<Profession> beforeEnd=professionService.getBefore();
        List<Profession> afterEnd=professionService.getAfter();
        model.addAttribute("java",java);
        model.addAttribute("css",css);
        model.addAttribute("professions",professions);
        model.addAttribute("beforeEnd",beforeEnd);
        model.addAttribute("afterEnd",afterEnd);
        return "t11";
    }
}
