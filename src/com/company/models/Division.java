package com.company.models;

import com.company.enums.Action;

public class Division extends Exercise {

    private float result;

    @Override
    public void calculate() {

        if (b == 0){
            throw new ArithmeticException("Деление на 0");
        }
        result = (float)a/(float)b;
    }

    @Override
    public String getResult() {
        return a + Action.DIVISION.getSign() + b + Action.EQUAL.getSign() + result;
    }
}
