package com.dong4j.example;

/**
 * Created by: dong4j.
 * Date: 2017-01-18.
 * Time: 17:29.
 * Description:
 */
public class Operation {
    private double numberA;
    private double numberB;
    private String operateType;
    public Operation(String operateType, double numberA, double numberB){
        this.numberA = numberA;
        this.numberB = numberB;
        this.operateType = operateType;
    }
    public double getResult(){
        double result = 0;
        switch (operateType) {
            case "+":
                return numberA + numberB;
            case "-":
                return numberA - numberB;
            case "*":
                return numberA * numberB;
            case "/":
                if(numberB == 0) return 0;
                return numberA / numberB;
        }
        return result;
    }
}
