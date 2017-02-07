package com.dong4j.singleton;

/**
 * Created by: dong4j.
 * Date: 2017-02-07.
 * Time: 21:33.
 * Description: 懒汉模式 多线程优化
 */
public class SynchronizedLazySingleton {
    private static SynchronizedLazySingleton instance = null;
    private SynchronizedLazySingleton(){}
    public static SynchronizedLazySingleton getInstance(){
        if(instance == null){
            synchronized (SynchronizedLazySingleton.class){
                instance = new SynchronizedLazySingleton();
            }
        }
        return instance;
    }
}
