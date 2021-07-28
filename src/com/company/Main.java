package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Quiz> questions = new ArrayList<>();
    static QuizResult quizResult = new QuizResult();
    // Константы для цвета в командной строке
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        Main.init();
        Main.start();
        Main.results();
    }

    /**
     * Метод инициализации пула вопросов
     */
    private static void init() {

        Quiz firstQuestion = new Quiz();
        firstQuestion.text = "Автор теории общественного договора как основы концепции антифеодального государства и права, свободного развития личности:";
        firstQuestion.answers = new String[]{"1. Кант", "2. Руссо", "3. Монтескье", "4. Гегель"};
        firstQuestion.rightAnswer = 2;
        questions.add(firstQuestion);

        Quiz secondQuestion = new Quiz();
        secondQuestion.text = "Автор поэм предпринявший попытки рационализации представления об этическом, нравственно-правовом порядке в человеческих делах и отношениях:";
        secondQuestion.answers = new String[]{"1. Фалес", "2. Солон", "3. Гомер", "4. Хилон"};
        secondQuestion.rightAnswer = 3;
        questions.add(secondQuestion);

        Quiz thirdQuestion = new Quiz();
        thirdQuestion.text = "Автором «Народной монархии» является:";
        thirdQuestion.answers = new String[]{"1. А. Тихомиров", "2. П. Победоносцев", "3. Д. Кавелин", "4. Бакунин", "5. А.Ильин", "6. Н. Леонтьев", "7. Л.Солоневич"};
        thirdQuestion.rightAnswer = 7;
        questions.add(thirdQuestion);
    }

    /**
     * Метод проведения тестирования
     */
    private static void start() {

        Scanner sc = new Scanner(System.in);
        String userInput;
        int answerNum;

        // Проходим по списку вопросов
        for (Quiz question : questions) {
            // Выводим текст вопроса
            System.out.println(question.number + ". " + question.text);
            System.out.println(" ");
            // Выводим все варианты ответов
            for (String answer : question.answers) {
                System.out.println("\t" + answer);
            }
            System.out.println(" ");

            // Считываем ответ пользователя и убеждаемся, что он является числом
            boolean is_digital = false;
            do {
                System.out.print("Ваш ответ: ");
                userInput = sc.nextLine();
                if (userInput.matches("[-+]?\\d+")) {
                    is_digital = true;
                }else {
                    System.out.println(ANSI_RED + "Пожалуйста, введите число" + ANSI_RESET);
                }
            } while (is_digital == false);

            answerNum = Integer.parseInt(userInput);

            // Выполняем проверку введенного ответа. Фиксируем статистику по ответам
            quizResult.questionCounter++;
            if (answerNum == question.rightAnswer) {
                System.out.println(ANSI_GREEN + "Верно :)" + ANSI_RESET);
                quizResult.successCounter++;
            } else {
                System.out.println(ANSI_RED + "Ошибка :(" + ANSI_RESET);
                quizResult.failCounter++;
            }
            System.out.println(" ");
        }
    }

    /**
     * Метод отображения результатов тестирования
     */
    private static void results() {
        double successValue = quizResult.successCounter / (double) quizResult.questionCounter * 100;
        successValue = Math.round(successValue * 100) / 100;
        System.out.println(ANSI_BLUE + "Тестирование завершено!" + ANSI_RESET);
        System.out.println("Всего задано вопросов: " + ANSI_BLUE + quizResult.questionCounter + ANSI_RESET);
        System.out.println("Верных ответов: " + ANSI_BLUE + quizResult.successCounter + ANSI_RESET);
        System.out.println("Ошибок: " + ANSI_BLUE + quizResult.failCounter + ANSI_RESET);
        if (quizResult.successCounter >= quizResult.failCounter) {
            System.out.println("Вы молодец на " + ANSI_GREEN + successValue + "%" + ANSI_RESET
                    + " :)");
        } else {
            System.out.println("Вы молодец на " + ANSI_RED + successValue + "%" + ANSI_RESET
                    + " Нужно чуть-чуть подучить ;)");
        }

    }
}
