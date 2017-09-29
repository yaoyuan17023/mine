package com.jnshu.controller;

import com.jnshu.entities.Profession;
import com.jnshu.entities.Student;
import com.jnshu.entities.User;
import com.jnshu.service.ProfessionService;
import com.jnshu.service.StudentService;
import com.jnshu.service.UserService;
import com.jnshu.utils.DES;
import com.jnshu.utils.MD5Util;
import com.jnshu.utils.SMS;
import com.jnshu.utils.TypeUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.http.cookie.SM;
import org.apache.ibatis.annotations.Param;
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
import java.io.*;
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

    @Autowired
    private SMS sms;

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
    public String register(User user, Integer message,HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer verify= (Integer) session.getAttribute("verify");
        String pic= (String) session.getAttribute("picture");
        logger.info("verify="+verify);
        logger.info("message="+message);
        if (message.equals(verify)&&message != null){
            User user1=new User();
            user1.setUser(user.getUser());
            String md5= MD5Util.stringToMD5(user.getUser()+user.getPassword());
            user1.setPassword(md5);
            user1.setMobile(user.getMobile());
            user1.setEmail(user.getEmail());
            user1.setPicture("../picture/"+pic);
            userService.sendEmail(user.getEmail());
            userService.insert(user1);
            return "success";
        }else{
            return "fail";
        }
    }

    //获取验证码
    @RequestMapping(value = "/mobile",method = RequestMethod.GET)
    public void getVerify(String mobile,HttpServletRequest request){
        logger.info("mobile number=" + mobile);
        //验证码
        Integer verify = (int)((Math.random()*9+1)*100000);
        String number=verify.toString();
        sms.sendMessage(mobile,number);
        HttpSession session = request.getSession();
        session.setAttribute("verify",verify);
    }

    @RequestMapping(value = "/pic",method = RequestMethod.GET)
    public String aa(){
        return "pic";
    }
    @RequestMapping(value = "/pic",method = RequestMethod.POST)
    public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解决上传文件名的中文乱码
        upload.setHeaderEncoding("UTF-8");
        factory.setSizeThreshold(1024 * 500);//设置内存的临界值为500K
        File linshi = new File("F:\\linshi");//当超过500K的时候，存到一个临时文件夹中
        factory.setRepository(linshi);
        upload.setSizeMax(1024 * 1024 * 5);//设置上传的文件总的大小不能超过5M
        try {
            // 1. 得到 FileItem 的集合 items
            List<FileItem> /* FileItem */items = upload.parseRequest(request);

            // 2. 遍历 items:
            for (FileItem item : items) {
                // 若是文件域则把文件保存到 e:\\files 目录下.
                    String fileName = item.getName();
                    long sizeInBytes = item.getSize();
                    System.out.println(fileName);
                    System.out.println(sizeInBytes);
                    HttpSession session = request.getSession();
                    session.setAttribute("picture",fileName);
                    InputStream in = item.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;

                    fileName = "c:\\Users\\HP\\IdeaProjects\\mytask\\src\\main\\webapp\\picture\\" + fileName;//文件最终上传的位置
                    System.out.println("这是什么"+fileName);
                    OutputStream out = new FileOutputStream(fileName);
                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }
                    userService.qingniu(fileName);
                    out.close();
                    in.close();
                }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
return "regist";
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
