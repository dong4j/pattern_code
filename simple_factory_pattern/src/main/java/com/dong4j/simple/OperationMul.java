package com.dong4j.simple;

/**
 * Created by: dong4j.
 * Date: 2017-01-18.
 * Time: 18:17.
 * Description:
 */
public class OperationMul extends Operation{
    @Override
    public double getResult(){
        return getNumberA() * getNumberB();
    }
}
