package com.jnshu.controller;

import com.jnshu.entities.Profession;
import com.jnshu.entities.Student;
import com.jnshu.entities.User;
import com.jnshu.service.ProfessionService;
import com.jnshu.service.StudentService;
import com.jnshu.service.UserService;
import com.jnshu.utils.DES;
import com.jnshu.utils.MD5Util;
import com.jnshu.utils.TypeUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.util.Password;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * created by 姚远 on 2017/9/4.
 */
@Controller
public class Dogg {
    private static Logger logger=Logger.getLogger(Dogg.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProfessionService professionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getAll(Model model) {
        int working = studentService.selectStudentNumber(0);
        int total = studentService.selectStudentNumber(null);
        List<Student> students = studentService.studentAll();
        model.addAttribute("working", working);
        model.addAttribute("total", total);
        model.addAttribute("students", students);
        return "t10";
    }

    @RequestMapping(value = "/u/job", method = RequestMethod.GET)
    public String professionAll(Model model) {
        int java = professionService.selectNumber(1);
        int css = professionService.selectNumber(2);
        List<Profession> professions = professionService.selectProfessionAll();
        List<Profession> beforeEnd = professionService.getBefore();
        List<Profession> afterEnd = professionService.getAfter();
        model.addAttribute("java", java);
        model.addAttribute("css", css);
        model.addAttribute("professions", professions);
        model.addAttribute("beforeEnd", beforeEnd);
        model.addAttribute("afterEnd", afterEnd);
        return "t11";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLog() {
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws ServletException, IOException {
//        boolean loginType=userService.isRightUser(user.getUser(),user.getPassword());
//        if (loginType){
            //如果验证通过，则将用户信息传到前台
//            request.setAttribute("user",user);
            //并跳转到对应网页
//            return "redirect:/home";
//        }else {
//            request.setAttribute("message","用户名密码错误");
//            return "redirect:/error";
//        }
//    }

    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String error(){
        return "error";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(@RequestParam("user") String user, @RequestParam("password") String password,
                      HttpServletResponse httpServletResponse) {
        String md5= MD5Util.stringToMD5(user+password);
        if(userService.isRightUser(user,md5)){
            //待加密内容
            long id=userService.selectByName(user).getId();
            long Date=new Date().getTime();
            String str = id+"="+Date;
            //加密操作
            byte[] result =  DES.encrype(str.getBytes() ,"12345678");
            //把加密的字节转换为16进制
            String resules= TypeUtil.bytesToHexString(result);
            Cookie cookie = new Cookie("token",resules);
            cookie.setMaxAge(60*60*24*7);//保留7天
            httpServletResponse.addCookie(cookie);
            try {
                httpServletResponse.sendRedirect("u/job");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                httpServletResponse.sendRedirect("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //注册页面
    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public String regist(){
        return "regist";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam("user") String user, @RequestParam("password") String password){
        String md5= MD5Util.stringToMD5(user+password);
        userService.insert(user,md5);
        logger.info("----->"+user+md5);
        return "success";
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletResponse response){
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/home";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "baseTemplate";
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String test2(){
        return "firstTemplate";
    }

    @RequestMapping(value = "/test3",method = RequestMethod.GET)
    public String test3(Model model){
        model.addAttribute("body","body");
        return "baseTemplate";
    }
    @RequestMapping(value = "/test4",method = RequestMethod.GET)
    public String test4(Model model){
        model.addAttribute("body","body2");
        return "baseTemplate";
    }

    @RequestMapping("/user/list")
    public String list(Model model){
        model.addAttribute("users",userService.userAll());
        return "list";
    }
}
