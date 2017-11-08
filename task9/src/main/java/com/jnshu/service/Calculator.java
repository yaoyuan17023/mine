package com.jnshu.service;











//import org.osoa.sca.annotations.Reference;

import org.oasisopen.sca.annotation.Reference;

import java.lang.annotation.Annotation;

/**
 * Created by Tom on 2017/5/25.
 */

public class Calculator implements ICalculator{

    /**
     * 引用其他组件IAdd，ISubtract，IMultiply,IDivide
     * @Reference 说明引用其他组件 会和.composite文件进行配置
     */
    private IAdd add;//加法组件
    private ISubtract subtract;//减法组件
    private IMultiply multiply;//乘法组件
    private IDivide divide;//除法组件
    public IAdd getAdd() {
        return add;
    }
    @Reference
    public void setAdd(IAdd add) {
        this.add = add;
    }

    public ISubtract getSubtract() {
        return subtract;
    }
    @Reference
    public void setSubtract(ISubtract subtract) {
        this.subtract = subtract;
    }

    public IMultiply getMultiply() {
        return multiply;
    }
    @Reference
    public void setMultiply(IMultiply multiply) {
        this.multiply = multiply;
    }

    public IDivide getDivide() {
        return divide;
    }
    @Reference
    public void setDivide(IDivide divide) {
        this.divide = divide;
    }

    @Override
    public double add(double n1, double n2) {
        return this.add.add(n1, n2);
    }

    @Override
    public double subtract(double n1, double n2) {
        return this.subtract.subtract(n1, n2);
    }

    @Override
    public double divide(double n1, double n2) {
        return this.divide.divide(n1, n2);
    }

    @Override
    public double multiply(double n1, double n2) {
        return this.multiply.multiply(n1, n2);
    }
}
