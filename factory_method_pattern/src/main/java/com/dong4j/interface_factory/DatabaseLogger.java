package com.dong4j.interface_factory;

/**
 * Created by: dong4j.
 * Date: 2017-01-19.
 * Time: 12:27.
 * Description: 具体产品
 */
public class DatabaseLogger implements Logger{
    @Override
    public void writeLog(){
        System.out.println("将日志写入数据库");
    }
}
