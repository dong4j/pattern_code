package com.dong4j;

import com.dong4j.simple.OperationFactory;
import org.junit.Test;

/**
 * Created by: dong4j.
 * Date: 2017-01-18.
 * Time: 17:36.
 * Description: 测试
 */
public class OperationTest {
    /**
     * Gets result.
     * @throws Exception the exception
     */
    @Test
    public void exampleTest() throws Exception {
        com.dong4j.example.Operation operation1 = new com.dong4j.example.Operation("+",101.0,10.0);
        System.out.println(operation1.getResult());
        com.dong4j.example.Operation operation2 = new com.dong4j.example.Operation("-",-0.01,100.0);
        System.out.println(operation2.getResult());
        com.dong4j.example.Operation operation3 = new com.dong4j.example.Operation("*",20.0,0.0);
        System.out.println(operation3.getResult());
        com.dong4j.example.Operation operation4 = new com.dong4j.example.Operation("/",10.0,0.0);
        System.out.println(operation4.getResult());
    }

    /**
     * Simple factory test.
     * 使用简单工厂获取操作类对象进行计算
     * @throws Exception the exception
     */
    @Test
    public void simpleFactoryTest() throws Exception {
        com.dong4j.simple.Operation operation = OperationFactory.createOperation("+");
        operation.setNumberA(101.0);
        operation.setNumberB(10.0);
        System.out.println(operation.getResult());

        operation = OperationFactory.createOperation("-");
        operation.setNumberA(-0.01);
        operation.setNumberB(100.0);
        System.out.println(operation.getResult());

        operation = OperationFactory.createOperation("*");
        operation.setNumberA(20);
        operation.setNumberB(0.0);
        System.out.println(operation.getResult());

        operation = OperationFactory.createOperation("/");
        operation.setNumberA(10.0);
        operation.setNumberB(0.0);
        System.out.println(operation.getResult());
    }
}