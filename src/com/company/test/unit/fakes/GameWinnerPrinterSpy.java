package com.company.test.unit.fakes;

import com.company.application.game.GameWinnerPrinter;
import com.company.application.game.Player;

import java.util.List;

public class GameWinnerPrinterSpy implements GameWinnerPrinter {

    private final List<String> actualFlow;

    public GameWinnerPrinterSpy(List<String> actualFlow) {
        this.actualFlow = actualFlow;
    }

    @Override
    public void printWinner(Player winner) {
        String printResult;
        if (winner == null){
            printResult = "Ничья";
        }else{
            printResult = "Победитель: " + winner.getName();
        }
        actualFlow.add(printResult);
    }

}