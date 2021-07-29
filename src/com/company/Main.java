package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Инициализация трёхмерного массива с базов вопросов. Внутри 2 уровня массива 3 блока: 1 - вопрос, 2 - варианты ответов, 3 - правильный вариант ответа
        String[][][] quiz = {
                {
                        {"Автор теории общественного договора как основы концепции антифеодального государства и права, свободного развития личности:"},
                        {"1. Кант", "2. Руссо", "3. Монтескье", "4. Гегель"},
                        {"2"}
                },
                {
                        {"Автор поэм предпринявший попытки рационализации представления об этическом, нравственно-правовом порядке в человеческих делах и отношениях:"},
                        {"1. Фалес", "2. Солон", "3. Гомер", "4. Хилон"},
                        {"3"}
                },
                {
                        {"Автором «Народной монархии» является:"},
                        {"1. А. Тихомиров", "2. П. Победоносцев", "3. Д. Кавелин", "4. Бакунин", "5. А.Ильин", "6. Н. Леонтьев", "7. Л.Солоневич"},
                        {"7"}
                }
        };

        // Объявляем необходимые переменные и константы
        Scanner sc = new Scanner(System.in);
        String userInput; // Здесь будет сохраняться ответ пользователя
        int questionCounter = 0; // Счётчик вопросов
        int successCounter = 0; // Счётчик правильных ответов
        int failCounter = 0; // Счётчик неправильных ответов
        // Константы для цвета шрифта в терминале
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_BLUE = "\u001B[34m";


        // Проходим по списку вопросов
        for (String[][] question : quiz) {
            // Выводим текст вопроса
            System.out.println(question[0][0]);
            System.out.println();
            // Выводим все варианты ответов
            for (String answer : question[1]) {
                System.out.println("\t" + answer);
            }
            System.out.println();

            System.out.print("Ваш ответ: ");
            userInput = sc.nextLine();

            // Выполняем проверку введенного ответа. Фиксируем статистику по ответам
            questionCounter++;
            if (userInput.equals(question[2][0])) {
                System.out.println(ANSI_GREEN + "Верно :)" + ANSI_RESET);
                successCounter++;
            } else {
                System.out.println(ANSI_RED + "Ошибка :(" + ANSI_RESET);
                failCounter++;
            }
            System.out.println();
        }

        //Выводим результаты тестирования
        double successValue = successCounter / (double) questionCounter * 100;
        successValue = Math.round(successValue * 100.0) / 100.0;
        System.out.println(ANSI_BLUE + "Тестирование завершено!" + ANSI_RESET);
        System.out.println("Всего задано вопросов: " + ANSI_BLUE + questionCounter + ANSI_RESET);
        System.out.println("Верных ответов: " + ANSI_BLUE + successCounter + ANSI_RESET);
        System.out.println("Ошибок: " + ANSI_BLUE + failCounter + ANSI_RESET);
        if (successCounter >= failCounter) {
            System.out.println("Вы молодец на " + ANSI_GREEN + successValue + "%" + ANSI_RESET
                    + " :)");
        } else {
            System.out.println("Вы молодец на " + ANSI_RED + successValue + "%" + ANSI_RESET
                    + " Нужно чуть-чуть подучить ;)");
        }
    }
}
