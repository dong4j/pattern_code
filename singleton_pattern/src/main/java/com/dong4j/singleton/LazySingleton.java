package com.dong4j.singleton;

/**
 * Created by: dong4j.
 * Date: 2017-02-07.
 * Time: 21:30.
 * Description:懒汉模式 真正使用时才创建
 */
public class LazySingleton {
    private static LazySingleton instance = null;
    private LazySingleton() throws Exception {
        throw new RuntimeException("单例模式险些被破坏，第二个对象未创建成功");
    }
    public static LazySingleton getInstance() throws Exception {
        return new LazySingleton();
    }
}
