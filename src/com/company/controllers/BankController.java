package com.company.controllers;
import com.company.models.Account;
import com.company.models.Bank;
import com.company.models.Client;
import com.company.utils.DataGenerator;
import com.company.utils.IO;
import com.company.utils.Timer;

import java.util.Map;
import java.util.TreeMap;

public class BankController {

    static public void searchClientByAccount(Bank bank) {
        IO.println();
        IO.print("Введите номер счёта для поиска: ");
        long accountNumber = IO.getInputLong();

        Timer timer = new Timer();
        Account account = new Account(accountNumber);
        Client client = bank.findClient(account);
        if (client != null){
            IO.println("Найден клиент");
            IO.println(client.toString(), IO.FontColor.ANSI_GREEN);
            IO.println("Счета клиента");
            ClientController.showAccounts(client);
        }else{
            IO.println("Клиент по запрашиваемому счёту не найден", IO.FontColor.ANSI_RED);
        }
        timer.showResult();
        IO.println();
    }

    public static void generateClients(Bank bank){
        DataGenerator.generateClients(bank);
    }

    // OK
    public static void showPartOfAccounts(Bank bank, int num){

        Map<Long, Client> accounts = bank.getAccounts();
        IO.println("Случайные 10 счетов: ");
        Map<Long, Client> myNewMap = accounts.entrySet().stream()
                .limit(num)
                .collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
        myNewMap.forEach((k,v) -> IO.println(k.toString(), IO.FontColor.ANSI_GREEN));
    }
}
