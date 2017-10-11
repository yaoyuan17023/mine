package com.jnshu.test;

import com.jnshu.entities.Student;
import com.jnshu.service.StudentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * created by 姚远 on 2017/10/10.
 */
public class TestClient {
    public static void main (String [] args)throws NotBoundException,
            java.net.MalformedURLException,
            RemoteException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/client1.xml");
        StudentService studentService = (StudentService) context.getBean("StudentService");
        try {
            System.out.println(studentService.studentAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
