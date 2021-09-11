package com.company.application.game;

import java.util.Random;

public class DiceImpl implements Dice {
    @Override
    public int roll() {
        // https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
        return new Random().nextInt();

/* Код, для которого тест будет успешен */
//        Random random = new Random();
//        return random.nextInt(5) + 1;
    }
}
