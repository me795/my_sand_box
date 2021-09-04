package com.company.exceptions;

public class NumberOfArgsException extends Exception{

    private final int detail;

    public NumberOfArgsException(int detail, String message) {
        super(message);
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MyException{"
                + "detail=" + detail
                + ", message=" + getMessage()
                + "} ";
    }
}
