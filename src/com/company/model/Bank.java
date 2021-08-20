package com.company.model;

import com.company.utils.CustomGenerator;
import com.company.utils.IOController;
import com.company.utils.Timer;

import java.util.Map;
import java.util.TreeMap;

public class Bank {

    // Правильно, что интерфейс
    // ДЗ: Поиск должен работать максимально быстро(!!!) с использованием стандартных коллекций Java.
    // https://habr.com/ru/post/237043/
    private Map<Long, Client> accounts = new TreeMap(); // TODO: !!! Точно TreeMap ?

    public Bank(){
        //TODO: хорошо, что CustomGenerator, но лучше где-то снаружи,
        // чтобы можно было создать и просто банк без клиентов или с другими клиентами
        CustomGenerator.generateClients(this);
    }

    //TODO: переименовать putClientIntoMap -> addClient
    // позже это может быть и не Map
    // к названиям типов не привязывайтесь в именах переменных, методов
    public void putClientIntoMap(long accountNumber, Client client){
        accounts.put(accountNumber,client);
    }

    //TODO: По ДЗ должен быть метод Client findClient(Account account)
    private Client getClientByAccount(long accountNumber){
        return accounts.get(accountNumber);
    }

    // OK
    public void showPartOfAccounts(int num){

        IOController.println("Случайные 10 счетов: ");
        Map<Long, Client> myNewMap = accounts.entrySet().stream()
                .limit(num)
                .collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
        myNewMap.forEach((k,v) -> IOController.println(k.toString(), IOController.FontColor.ANSI_GREEN));
    }

    //TODO: выделить в отдельный класс, Bank - данные, бизнес-логика, но не взаимодействие с пользователем
    // MVC - данные отдельно, взаимодействие с пользователем отдельно
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
