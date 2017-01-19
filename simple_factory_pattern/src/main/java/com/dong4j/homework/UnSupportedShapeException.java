package com.dong4j.homework;

/**
 * Created by: dong4j.
 * Date: 2017-01-19.
 * Time: 11:09.
 * Description:
 */
public class UnSupportedShapeException extends Exception{
    public UnSupportedShapeException(){
        super("不支持的图形");
    }
}
