package com.dong4j.factory;

/**
 * Created by: dong4j.
 * Date: 2017-01-20.
 * Time: 21:14.
 * Description:
 */
public class SpringButton implements Button{
    @Override
    public void display() {
        System.out.println("spring 风格按钮");
    }
}
