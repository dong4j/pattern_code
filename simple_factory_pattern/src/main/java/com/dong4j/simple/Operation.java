package com.dong4j.simple;

/**
 * Created by: dong4j.
 * Date: 2017-01-18.
 * Time: 18:14.
 * Description: 操作类父类,用于封装被操作的属性
 */
public class Operation {
    private double numberA;
    private double numberB;

    public Operation(){

    }

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public double getResult() throws Exception {
        return (double) 0;
    }

    // 再次优化, 将创建具体操作类的方法放在父类中,不再使用简单工厂
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
