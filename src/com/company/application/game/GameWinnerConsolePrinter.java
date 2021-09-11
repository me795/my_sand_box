package com.company.application.game;

public class GameWinnerConsolePrinter implements GameWinnerPrinter {
    @Override
    public void printWinner(Player winner) {
        System.out.printf("Победитель: %s%n", winner.getName());

        /* Код, для которого тест будет успешен */
//        if (winner == null){
//            System.out.print("Ничья");
//        }else{
//            System.out.printf("Победитель: %s%n", winner.getName());
//        }
    }
}
