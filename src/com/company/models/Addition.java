package com.company.models;

import com.company.enums.Action;

public class Addition extends Exercise {

    private int result;

    @Override
    public void calculate() {
        result = a + b;
    }

    @Override
    public String getResult() {
        return a + Action.ADDITION.getSign() + b + Action.EQUAL.getSign() + result;
    }
}
