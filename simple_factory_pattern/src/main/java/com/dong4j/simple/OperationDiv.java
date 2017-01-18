package com.dong4j.simple;

/**
 * Created by: dong4j.
 * Date: 2017-01-18.
 * Time: 18:17.
 * Description:
 */
public class OperationDiv extends Operation{
    @Override
    public double getResult() throws Exception {
        if(getNumberB() == 0){
            throw new Exception("除数不能为0");
        }
        return getNumberA() / getNumberB();
    }
}
