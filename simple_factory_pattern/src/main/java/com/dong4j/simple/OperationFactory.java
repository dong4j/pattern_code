package com.dong4j.simple;

/**
 * Created by: dong4j.
 * Date: 2017-01-18.
 * Time: 18:13.
 * Description:
 */
public class OperationFactory {
    public static Operation createOperation(String operationType) throws Exception {
        switch (operationType){
            case "+":
                return new OperationAdd();
            case "-":
                return new OperationSub();
            case "*":
                return new OperationMul();
            case "/":
                return new OperationDiv();
            default:
                throw new Exception("操作不允许");
        }
    }
}
