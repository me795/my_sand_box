package com.company;

public class Quiz {

    int number;
    String text;
    String[] answers;
    int rightAnswer;

    static int count = 1;

    public Quiz() {
        //Автоматическая нумерация вопросов при создании объекта
        this.number = count++;
    }
}
