package com.company.models;

public abstract class Exercise {

    protected int a;
    protected int b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public abstract void calculate();

    public abstract String getResult();
}
