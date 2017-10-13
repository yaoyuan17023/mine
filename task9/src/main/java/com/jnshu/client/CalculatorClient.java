package com.jnshu.client;
import com.jnshu.service.*;
/**
 * Created by Tom on 2017/5/25.
 */
public class CalculatorClient {
    public static void main(String [] args){
        //java 实现方式
        Calculator c = new Calculator();
        IAdd add = new Add();
        c.setAdd(add);
        System.out.println("3 + 2 = "+c.add(3, 2));

        ISubtract subtract = new Subtract();
        c.setSubtract(subtract);
        System.out.println("3 - 2 = "+c.subtract(3, 2));

        IMultiply multiply = new Multiply();
        c.setMultiply(multiply);
        System.out.println("3 * 2 = "+c.multiply(3, 2));

        IDivide divide= new Divide();
        c.setDivide(divide);
        System.out.println("3 / 2 = "+c.divide(3, 2));
    }
}
