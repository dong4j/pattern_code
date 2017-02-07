package com.dong4j.singleton;

import java.lang.reflect.Constructor;

/**
 * Created by: dong4j.
 * Date: 2017-02-07.
 * Time: 21:55.
 * Description:
 */
public class Test {
    @org.junit.Test
    public void test(){
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton1 == enumSingleton2);
    }

    @org.junit.Test
    public void test1() throws Exception {
        LazySingleton singleton1 = LazySingleton.getInstance();
        Class       c           = Class.forName(LazySingleton.class.getName());
        Constructor constructor = c.getDeclaredConstructor();
        // 能访问私有构造方法
        constructor.setAccessible(true);
        // 利用私有构造方法创建一个新的单例对象,破坏单例模式
        LazySingleton singleton2 = (LazySingleton)constructor.newInstance();
        System.out.println(singleton1 == singleton2);
    }
}
