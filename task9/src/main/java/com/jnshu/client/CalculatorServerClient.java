package com.jnshu.client;
import com.jnshu.service.Calculator;
import com.jnshu.service.ICalculator;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;


import java.io.IOException;



/**
 * tuscany   2.0.1 service 和客户端 测试
 * Created by Tom on 2017/5/25.
 */
public class CalculatorServerClient {
    public static void main(String[] args) throws IOException {
        Node node = NodeFactory.newInstance().createNode("Calculator.composite");
        node.start();
        System.out.println("service启动");
        ICalculator c = node.getService(ICalculator.class,"Calculator");
        System.out.println(c.add(2, 2));
        System.out.println("3 + 2 = " + c.add(3, 2));
        System.out.println("3 - 2 = " + c.subtract(3, 2));
        System.out.println("3 * 2 = " + c.multiply(3, 2));
        System.out.println("3 / 2 = " + c.divide(3, 2));
        node.stop();
    }
}
