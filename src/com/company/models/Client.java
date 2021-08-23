package com.company.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {

    private Map<Long, Account> accounts = new HashMap(); //TODO: !!! точно List?
    private String fullname;
    private Date birthday;

    public Client(String fullname, Date birthday){
        this.fullname = fullname;
        this.birthday = birthday;
    }

    //TODO: Если есть add, то должен быть и remove?
    public void addAccount(Account account) {
        accounts.put(account.getNumber(),account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account.getNumber());
    }

    @Override
    public String toString(){

        String pattern = "dd-MM-yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        String birthdayAsString = df.format(birthday.getTime());

        return "Имя клиента: " + fullname + " | Дата рождения: " + birthdayAsString;

    }

    public Map<Long, Account> getAccounts() {
        return accounts;
    }
}
