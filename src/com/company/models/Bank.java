package com.company.models;

import com.company.utils.DataGenerator;
import com.company.utils.IO;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Bank {

    // Правильно, что интерфейс
    // ДЗ: Поиск должен работать максимально быстро(!!!) с использованием стандартных коллекций Java.
    // https://habr.com/ru/post/237043/
    private Map<Long, Client> accounts = new HashMap(); // TODO: !!! Точно TreeMap ?

    //TODO: переименовать putClientIntoMap -> addClient
    // позже это может быть и не Map
    // к названиям типов не привязывайтесь в именах переменных, методов
    public void addClient(Account account, Client client){
        accounts.put(account.getNumber(),client);
    }

    //TODO: По ДЗ должен быть метод Client findClient(Account account)
    public Client findClient(Account account){
        return accounts.get(account.getNumber());
    }


    public Map getAccounts(){
        return accounts;
    }



}
