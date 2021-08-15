package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class CustomGenerator {

    public static void generateClients(Bank bank) {

        IOController.println("Генерируем клиентов банка и их счета...", IOController.FontColor.ANSI_BLUE);

        int numClients;
        int numAccounts = 0;

        String fullname;
        Date birthday;
        int minClients = 25000;
        int maxClients = 30000;
        numClients = (int) ((Math.random() * (maxClients - minClients)) + minClients);
        int minAccounts = 1;
        int maxAccounts = 5;
        int numClientAccounts;

        for (int i = 0; i < numClients; i++) {

            fullname = generateFullname();
            birthday = generateBirthday();
            Client client = new Client(fullname, birthday);

            numClientAccounts = (int) ((Math.random() * (maxAccounts - minAccounts)) + minAccounts);
            for (int j = 0; j < numClientAccounts; j++) {
                Account account = new Account();
                client.addAccount(account);
                bank.putClientIntoMap(account.getNumber(), client);
                numAccounts++;
            }

        }

        IOController.print("Сгенерировано клиентов: ");
        IOController.println(String.valueOf(numClients), IOController.FontColor.ANSI_GREEN);
        IOController.print("Сгенерировано счетов: ");
        IOController.println(String.valueOf(numAccounts), IOController.FontColor.ANSI_GREEN);
        IOController.println();
    }

    public static long generateAccountNumber() {
        long leftLimit = 10L;
        long rightLimit = 999999L;
        long generatedLong = ThreadLocalRandom.current().nextLong(leftLimit, rightLimit);
        long prefix = 4081781006543000000L;
        return prefix + generatedLong;
    }

    public static int generateAmount() {
        return (int) (Math.random() * 10000);
    }

    private static Date generateBirthday() {


        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date dMin = null;
        try {
            dMin = formatter.parse("01-01-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dMax = null;
        try {
            dMax = formatter.parse("01-01-1990");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date randomDate = new Date(ThreadLocalRandom.current()
                .nextLong(dMin.getTime(), dMax.getTime()));

        return randomDate;
    }

    private static String generateFullname() {

        return generateSurname() + " " + generateName();
    }

    private static String generateName() {

        String[] names = new String[]{"Александр",
                "Алексей",
                "Анатолий",
                "Андрей",
                "Антон",
                "Аркадий",
                "Артем",
                "Борислав",
                "Вадим",
                "Валентин",
                "Валерий",
                "Василий",
                "Виктор",
                "Виталий",
                "Владимир",
                "Вячеслав",
                "Геннадий",
                "Георгий",
                "Григорий",
                "Даниил",
                "Денис",
                "Дмитpий",
                "Евгений",
                "Егор",
                "Иван",
                "Игорь",
                "Илья",
                "Кирилл",
                "Лев",
                "Максим",
                "Михаил",
                "Никита",
                "Николай",
                "Олег",
                "Семен",
                "Сергей",
                "Станислав",
                "Степан",
                "Федор",
                "Юрий"};

        int max = names.length - 1;
        int index = (int) (Math.random() * max);
        return names[index];

    }

    private static String generateSurname() {

        String[] surnames = new String[]{"Иванов",
                "Смирнов",
                "Кузнецов",
                "Попов",
                "Васильев",
                "Петров",
                "Соколов",
                "Михайлов",
                "Новиков",
                "Фёдоров",
                "Морозов",
                "Волков",
                "Алексеев",
                "Лебедев",
                "Семёнов",
                "Егоров",
                "Павлов",
                "Козлов",
                "Степанов",
                "Николаев",
                "Орлов",
                "Андреев",
                "Макаров",
                "Никитин",
                "Захаров"};

        int max = surnames.length - 1;
        int index = (int) (Math.random() * max);
        return surnames[index];
    }


}
