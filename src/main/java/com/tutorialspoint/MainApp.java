package com.tutorialspoint;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by 姚远 on 2017/8/7.
 */
public class MainApp {
    public static void main(String[] args) {
        /**
         * 使用框架API ClassPathXmlApplicationContext()来创建应用程序的上下文，这个API
         * 加载beans的配置文件并最终基于所提供的API，它处理创建并初始化所有的对象
         */
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        /**
         * 使创建的上下文getBean（）方法来获得所需的bean，使用bean的ID返回一个最终可以装换
         * 为实体对象的通用对象，一旦有了对象，你就可以使用这个对象调用任何类的方法
         */
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
    }
}
