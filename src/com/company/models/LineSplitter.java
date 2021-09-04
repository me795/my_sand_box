package com.company.models;

import com.company.enums.Action;
import com.company.exceptions.NumberOfArgsException;

public class LineSplitter {

    private int a;
    private int b;
    private Action action;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public Action getAction() {
        return action;
    }

    public void splitLine(String line) throws NumberOfArgsException {

        line = line.trim();
        String[] arr;

            arr = line.split("\\+");
            if (arr.length == 2){
                action = Action.ADDITION;
            }else{
                arr = line.split("-");
                if (arr.length == 2){
                    action = Action.SUBTRACTION;
                }else{
                    arr = line.split("\\*");
                    if (arr.length == 2){
                        action = Action.MULTIPLICATION;
                    }else{
                        arr = line.split("/");
                        if (arr.length == 2){
                            action = Action.DIVISION;
                        }else{
                            throw new NumberOfArgsException(arr.length,"Неверное количество аргументов: ");
                        }
                    }
                }
            }
            a = Integer.parseInt(arr[0].trim());
            b = Integer.parseInt(arr[1].trim());
    }


}
