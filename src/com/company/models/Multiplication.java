package com.company.models;

import com.company.enums.Action;

public class Multiplication extends Exercise {

    private int result;

    @Override
    public void calculate() {
        result = a * b;
    }

    @Override
    public String getResult() {
        return a + Action.MULTIPLICATION.getSign() + b + Action.EQUAL.getSign() + result;
    }
}
