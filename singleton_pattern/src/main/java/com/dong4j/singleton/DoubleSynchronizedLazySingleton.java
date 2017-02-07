package com.dong4j.singleton;

/**
 * Created by: dong4j.
 * Date: 2017-02-07.
 * Time: 21:38.
 * Description:
 */
public class DoubleSynchronizedLazySingleton {
    private volatile static DoubleSynchronizedLazySingleton instance = null;
    private DoubleSynchronizedLazySingleton(){}
    public static DoubleSynchronizedLazySingleton getInstance(){
        if(instance == null){
            synchronized (DoubleSynchronizedLazySingleton.class){
                if(instance == null){
                    instance = new DoubleSynchronizedLazySingleton();
                }
            }
        }
        return instance;
    }
}
