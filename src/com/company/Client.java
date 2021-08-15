package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {

    private List<Account> accounts = new ArrayList<>();
    private String fullname;
    private Date birthday;

    public Client(String fullname, Date birthday){
        this.fullname = fullname;
        this.birthday = birthday;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public String toString(){

        String pattern = "dd-MM-yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        String birthdayAsString = df.format(birthday.getTime());

        return "Имя клиента: " + fullname + " | Дата рождения: " + birthdayAsString;

    }

    public void showAccounts() {

        for (Account account : accounts){
            IOController.println(account.toString(), IOController.FontColor.ANSI_GREEN);
        }
    }
}
