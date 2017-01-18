package com.dong4j.example;

/**
 * Created by: dong4j.
 * Date: 2017-01-18.
 * Time: 17:36.
 * Description: 测试
 */
public class OperationTest {
    @org.junit.Test
    public void getResult() throws Exception {
        System.out.println(Operation.getResult("/",10.0,0));
        System.out.println(Operation.getResult("+",101.0,10.0));
        System.out.println(Operation.getResult("-",-0.01,100));
        System.out.println(Operation.getResult("*",20.0,0));
    }
}