package com.company.models;

import com.company.enums.Action;

public class Subtraction extends Exercise {

    private int result;

    @Override
    public void calculate() {
        result = a - b;
    }

    @Override
    public String getResult() {
        return a + Action.SUBTRACTION.getSign() + b + Action.EQUAL.getSign() + result;
    }
}
