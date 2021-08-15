package com.company;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bank {

    private Map<Long, Client> accounts = new TreeMap();

    public Bank(){
        CustomGenerator.generateClients(this);
    }

    public void putClientIntoMap(long accountNumber, Client client){
        accounts.put(accountNumber,client);
    }

    private Client getClientByAccount(long accountNumber){
        return accounts.get(accountNumber);
    }

    public void showPartOfAccounts(int num){

        IOController.println("Случайные 10 счетов: ");
        Map<Long, Client> myNewMap = accounts.entrySet().stream()
                .limit(num)
                .collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
        myNewMap.forEach((k,v) -> IOController.println(k.toString(), IOController.FontColor.ANSI_GREEN));
    }

    public void searchClientByAccount() {
        IOController.println();
        IOController.print("Введите номер счёта для поиска: ");
        long accountNumber = IOController.getInputLong();

        Timer timer = new Timer();
        Client client = getClientByAccount(accountNumber);
        if (client != null){
            IOController.println("Найден клиент");
            IOController.println(client.toString(), IOController.FontColor.ANSI_GREEN);
            IOController.println("Счета клиента");
            client.showAccounts();
        }else{
            IOController.println("Клиент по запрашиваемому счёту не найден", IOController.FontColor.ANSI_RED);
        }
        timer.showResult();
        IOController.println();
    }

}
