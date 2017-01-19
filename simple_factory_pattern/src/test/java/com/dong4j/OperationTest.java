package com.dong4j;

import com.dong4j.homework.Graphics;
import com.dong4j.homework.UnSupportedShapeException;
import com.dong4j.simple.OperationFactory;
import com.dong4j.utils.ConfigUtil;
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
        operation.setNumberB(10.0);
        System.out.println(operation.getResult());
    }

    /**
     * Config test.
     * 使用配置工具类读取配置文件信息,避免修改客户端代码
     * @throws Exception the exception
     */
    @Test
    public void configTest() throws Exception {
        // 使用配置文件获取操作符
        String operationType = ConfigUtil.getType("operationType");
        com.dong4j.simple.Operation operation = OperationFactory.createOperation(operationType);
        operation.setNumberA(101.0);
        operation.setNumberB(10.0);
        System.out.println(operation.getResult());
    }

    /**
     * Operation static test.
     * 将创建具体操作类的静态方法简化到 Operation 类中, 去掉 OperationFactory.
     * @throws Exception the exception
     */
    @Test
    public void operationStaticTest() throws Exception {
        // 使用配置文件获取操作符
        String operationType = ConfigUtil.getType("operationType");
        com.dong4j.simple.Operation operation = com.dong4j.simple.Operation.createOperation(operationType);
        operation.setNumberA(110.0);
        operation.setNumberB(11.0);
        System.out.println(operation.getResult());
    }

    @Test
    public void graphicsTest() throws UnSupportedShapeException {
        String type = ConfigUtil.getType("type");
        Graphics graphics = Graphics.createGraphics(type);
        graphics.draw();
        graphics.erase();
    }
}