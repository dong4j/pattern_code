package com.dong4j.example;

/**
 * Created by: dong4j.
 * Date: 2017-01-18.
 * Time: 17:29.
 * Description:
 */
public class Operation {
    public static double getResult(String operate, double numberA, double numberB){
        double result = 0;
        switch (operate) {
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
