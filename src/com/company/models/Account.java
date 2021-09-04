package com.company.models;

import com.company.utils.DataGenerator;

public class Account {

    private final long number;
    private int amount;

    //TODO: добавить второй конструктор, чтобы можно было создать Account
    // (добавлен ниже)
    // Было так:
//    public Account() {
//        this.number = CustomGenerator.generateAccountNumber();
//        this.amount = CustomGenerator.generateAmount();
//    }

    public Account() {
        this(DataGenerator.generateAccountNumber(), DataGenerator.generateAmount());
    }

    public Account(long number) {
        this.number = number;
    }

    public Account(long number, int amount) {
//        if (number < 0 )
//            throw new IllegalArgumentException();

        this.number = number;
        this.amount = amount;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public String toString() {

        return "Номер счёта: " + number + " | Количество монет: " + amount;

    }
}
