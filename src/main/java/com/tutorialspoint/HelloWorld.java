package com.tutorialspoint;

/**
 * created by 姚远 on 2017/8/7.
 */
public class HelloWorld {
    private String message;
    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
}
