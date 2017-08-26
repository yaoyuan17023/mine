package com.atguigu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by 姚远 on 2017/8/18.
 */
@RequestMapping("/myRequest")
@Controller
public class HelloWorld {
    private static final String SUCCESS="success";

    @RequestMapping(value ="/testParams",params ={"name","age!=20"})
    public String testParams(){
        System.out.println("(=@__@=)");
        return SUCCESS;
    }

    /**
     * 使用method属性来指定请求方式
     */

    @RequestMapping(value = "/testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }
    /**
     * 1、使用@RequestMapper来映射请求
     * 2、返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver视图解析器会做如下的解析：
     *通过 prefix+returnVal+后缀 这样的方式得到实际的物理视图，然后做转发操作
     *
     * WEB.INF/views/success.jsp
     *
     * @return
     */
    @RequestMapping("/helloworld")
    public String hello(){
        System.out.println("hello world");
        return SUCCESS;
    }
    @RequestMapping("/pathVariable/id")
    public String pathVariable(@PathVariable("id")Integer id){
        System.out.println("hello "+id);
        return SUCCESS;
    }
}

