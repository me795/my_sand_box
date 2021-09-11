package com.company.test.unit;

import com.company.application.game.Dice;
import com.company.application.game.DiceImpl;

public class DiceImplTest {

    public void testRoll() {
        String scenario = "Тест броска игральной кости";
        try {

            Dice dice = new DiceImpl();
            int result;

            for (int i = 0; i < 10; i++) {
                result = dice.roll();
                if ((result < 0) || (result > 6)){
                    throw new Exception("Выброшено некорректное значение");
                }
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
