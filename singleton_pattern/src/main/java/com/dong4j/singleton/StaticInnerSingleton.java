package com.dong4j.singleton;

/**
 * Created by: dong4j.
 * Date: 2017-02-07.
 * Time: 21:42.
 * Description: 使用静态内部类实现单例模式
 */
public class StaticInnerSingleton {
    private StaticInnerSingleton(){}
    private static class HolderClass{
        private final static StaticInnerSingleton instance = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance(){
        return HolderClass.instance;
    }
}
