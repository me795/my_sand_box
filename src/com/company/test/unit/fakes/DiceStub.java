package com.company.test.unit.fakes;

import com.company.application.game.Dice;

public class DiceStub implements Dice {

    private final int firstRollResult;
    private final int secondRollResult;
    private boolean isFirstRollCall = true;

    public DiceStub(int firstRollResult, int secondRollResult){
        this.firstRollResult = firstRollResult;
        this.secondRollResult = secondRollResult;
    }

    @Override
    public int roll() {

        if (isFirstRollCall){
            isFirstRollCall = false;
            return firstRollResult;
        }else{
            return secondRollResult;
        }

    }

}
