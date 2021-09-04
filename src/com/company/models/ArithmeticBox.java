package com.company.models;

import com.company.enums.Action;
import com.company.exceptions.NumberOfArgsException;
import com.company.utils.IO;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticBox {

    List<Exercise> exercises = new ArrayList();

    public void addExercise(String line) {
        LineSplitter lineSplitter = new LineSplitter();

        try {
            lineSplitter.splitLine(line);

            Action action = lineSplitter.getAction();
            int a = lineSplitter.getA();
            int b = lineSplitter.getB();
            Exercise exercise = switch (action) {
                case ADDITION -> new Addition();
                case SUBTRACTION -> new Subtraction();
                case MULTIPLICATION -> new Multiplication();
                case DIVISION -> new Division();
                default -> throw new IllegalStateException("Unexpected value: " + action);
            };

            exercise.setA(a);
            exercise.setB(b);
            exercises.add(exercise);
        }catch (NumberFormatException | NumberOfArgsException e){
            IO.println(e.toString(), IO.FontColor.ANSI_RED);
        }

    }


    public void runCalculation(){
        exercises.forEach(ArithmeticBox::calculate);
    }

    private static void calculate(Exercise exercise) {
        try {
            exercise.calculate();
            String result = exercise.getResult();
            IO.println(result, IO.FontColor.ANSI_GREEN);
        }catch(ArithmeticException e){
            IO.println(e.toString(), IO.FontColor.ANSI_RED);
        }
    }
}
