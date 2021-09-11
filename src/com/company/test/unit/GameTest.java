package com.company.test.unit;

import com.company.application.game.Dice;
import com.company.application.game.Game;
import com.company.application.game.GameWinnerPrinter;
import com.company.application.game.Player;
import com.company.assertions.Assertions;
import com.company.test.unit.fakes.DiceStub;
import com.company.test.unit.fakes.GameWinnerPrinterSpy;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    public void testWinnerFirst() {
        String scenario = "Тест игры с победой первого игрока";
        try {
            List<String> expectedFlow = List.of("Победитель: Вася");
            List<String> actualFlow = new ArrayList<>();

            Dice dice = new DiceStub(4,3);
            GameWinnerPrinter winnerPrinter = new GameWinnerPrinterSpy(actualFlow);
            Game game = new Game(dice, winnerPrinter);
            game.playGame(new Player("Вася"), new Player("Игорь"));

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testWinnerSecond() {
        String scenario = "Тест игры с победой второго игрока";
        try {
            List<String> expectedFlow = List.of("Победитель: Игорь");
            List<String> actualFlow = new ArrayList<>();

            Dice dice = new DiceStub(3,4);
            GameWinnerPrinter winnerPrinter = new GameWinnerPrinterSpy(actualFlow);
            Game game = new Game(dice, winnerPrinter);
            game.playGame(new Player("Вася"), new Player("Игорь"));

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDraw() {
        String scenario = "Тест игры с ничейным результатом";
        try {
            List<String> expectedFlow = List.of("Ничья");
            List<String> actualFlow = new ArrayList<>();

            Dice dice = new DiceStub(3,3);
            GameWinnerPrinter winnerPrinter = new GameWinnerPrinterSpy(actualFlow);
            Game game = new Game(dice, winnerPrinter);
            game.playGame(new Player("Вася"), new Player("Игорь"));

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
