package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Account {

    private final long number;
    private int amount;

    public Account() {
        this.number = CustomGenerator.generateAccountNumber();
        this.amount = CustomGenerator.generateAmount();
    }

    public long getNumber(){
        return number;
    }

    @Override
    public String toString(){

        return "Номер счёта: " + number + " | Количество монет: " + amount;

    }
}
