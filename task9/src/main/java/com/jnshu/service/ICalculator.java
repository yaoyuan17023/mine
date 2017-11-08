package com.jnshu.service;










import java.rmi.Remote;

/**
 * Created by Tom on 2017/5/25.
 */
//@Remotable

public interface ICalculator{
    /**
     * 加法
     */
    double add(double n1, double n2);
    /**
     * 减法
     */
    double subtract(double n1, double n2);
    /**
     * 除法
     */
    double divide(double n1, double n2);
    /**
     * 乘法
     */
    double multiply(double n1, double n2);
}
