package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    private ArrayList<Question> questions = new ArrayList<>();
    private QuizResult quizResult = new QuizResult();

    // Константы для цвета в командной строке
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_BLUE = "\u001B[34m";

    public Quiz() {

        String text;
        String[] answerVariants;
        int rightAnswer;

        text = "Автор теории общественного договора как основы концепции антифеодального государства и права, свободного развития личности:";
        answerVariants = new String[]{"1. Кант", "2. Руссо", "3. Монтескье", "4. Гегель"};
        rightAnswer = 2;
        Question question1 = new Question(text,answerVariants,rightAnswer);
        questions.add(question1);

        text = "Автор поэм предпринявший попытки рационализации представления об этическом, нравственно-правовом порядке в человеческих делах и отношениях:";
        answerVariants = new String[]{"1. Фалес", "2. Солон", "3. Гомер", "4. Хилон"};
        rightAnswer = 3;
        Question question2 = new Question(text,answerVariants,rightAnswer);
        questions.add(question2);

        text = "Автором «Народной монархии» является:";
        answerVariants = new String[]{"1. А. Тихомиров", "2. П. Победоносцев", "3. Д. Кавелин", "4. Бакунин", "5. А.Ильин", "6. Н. Леонтьев", "7. Л.Солоневич"};
        rightAnswer = 7;
        Question question3 = new Question(text,answerVariants,rightAnswer);
        questions.add(question3);

    }

    /**
     * Метод проведения тестирования
     */
    public void start() {

        Scanner sc = new Scanner(System.in);
        String userInput;
        int userInputNum;
        int number = 1;
        String text;
        String[] answerVariants;
        boolean answerResult;

        // Проходим по списку вопросов
        for (Question question : questions) {
            // Выводим текст вопроса
            text = question.getText();
            System.out.println(number + ". " + text);
            System.out.println();
            // Выводим все варианты ответов
            answerVariants = question.getAnswerVariants();
            for (String answerVariant : answerVariants) {
                System.out.println("\t" + answerVariant);
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
            } while (!is_digital);

            userInputNum = Integer.parseInt(userInput);

            // Выполняем проверку введенного ответа. Фиксируем статистику по ответам
            answerResult = question.checkSuccessfulResult(userInputNum);
            if (answerResult) {
                System.out.println(ANSI_GREEN + "Верно :)" + ANSI_RESET);
                quizResult.countSuccessfulAnswer();
            } else {
                System.out.println(ANSI_RED + "Ошибка :(" + ANSI_RESET);
                quizResult.countFailedAnswer();
            }
            System.out.println();
            number++;
        }
    }

    /**
     * Метод отображения результатов тестирования
     */
    public void showTotalResult() {
        int successCounter = quizResult.getSuccessCounter();
        int questionCounter = quizResult.getQuestionCounter();
        int failCounter = questionCounter - successCounter;
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
