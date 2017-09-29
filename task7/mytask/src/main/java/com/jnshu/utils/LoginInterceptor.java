package com.jnshu.utils;

import com.jnshu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * created by 姚远 on 2017/9/12.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println("调用拦截器");
        Cookie[] cookie = httpServletRequest.getCookies();
        if(cookie != null) {
            System.out.println("有cookie才进来，我日你哥！");
            for (int i = 0; i < cookie.length; i++) {
                System.out.println("遍历");
                if (cookie[i].getName().equals("token")) {
                    try {
                        String token = cookie[i].getValue();
                        System.out.println("token="+token);
                        byte[] tk = TypeUtil.hexStringToByte(token);
                        byte[] tk1 = DES.decrypt(tk, "12345678");
                        String tk2 = new String(tk1);
                        System.out.println("cookie中的token进行解密");
                        String[] sArr=tk2.split("=");
                        String id=sArr[0];
                        String date=sArr[1];
                        Long time=Long.parseLong(date);
                        System.out.println("time="+time);
                        if (userService.select(Integer.parseInt(id)) != null) {
                            return true;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        String contextPath = httpServletRequest.getContextPath();
        String uri = contextPath + "/login";
        System.out.println("重定向路径：" + uri);
        httpServletResponse.sendRedirect(uri);
         return false;
        }




    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
