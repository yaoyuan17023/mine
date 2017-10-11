package com.jnshu.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by 姚远 on 2017/10/10.
 */
public class TestServer2 {
    public static void main(String[] args) throws InterruptedException {
        new ClassPathXmlApplicationContext("spring/spring-*.xml");

        Object lock = new Object();
        synchronized (lock) {
            lock.wait();
        }
    }
}
