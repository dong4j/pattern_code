package com.dong4j.singleton;

/**
 * Created by: dong4j.
 * Date: 2017-02-07.
 * Time: 21:27.
 * Description: 饿汉模式,类一加载就创建单例对象
 */
public class EagerSingleton {
    private  static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance(){
        return instance;
    }
}
