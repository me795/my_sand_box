package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean repeat;
        Scanner sc = new Scanner(System.in);
        String userInput;

        do {
            Quiz quiz = new Quiz();
            quiz.start();
            quiz.showTotalResult();

            System.out.print("Хотите повторить?[Да/Нет]: ");
            userInput = sc.nextLine();
            repeat = userInput.trim().equalsIgnoreCase("да");
            System.out.println();

        } while (repeat);
    }

}
