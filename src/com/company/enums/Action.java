package com.company.enums;

public enum Action {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    EQUAL("=");

    private final String sign;

    Action(String sign){
        this.sign = sign;
    }
    public String getSign(){ return sign;}
}
