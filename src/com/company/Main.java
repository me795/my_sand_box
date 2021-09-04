package com.company;

import com.company.controllers.ArithmeticController;
import com.company.exceptions.NumberOfArgsException;
import com.company.models.ArithmeticBox;
import com.company.models.Exercise;
import com.company.utils.IO;

public class Main {

    public static void main(String[] args) {
        ArithmeticController arithmeticController = new ArithmeticController();
        do {
            try {
                String userInput = arithmeticController.makeChoice();
                ArithmeticBox arithmeticBox = switch (userInput) {
                    case "1" -> arithmeticController.manualInput();
                    case "2" -> arithmeticController.fileInput();
                    default -> throw new IllegalArgumentException("Недопустимое значение: " + userInput);
                };

                arithmeticBox.runCalculation();
            } catch (IllegalArgumentException e) {
                IO.println(e.toString(), IO.FontColor.ANSI_RED);
            }

        } while (needToRepeat());

    }

    private static boolean needToRepeat() {
        IO.println("Повторить выполнение программы? (напишите \"да\" для подтверждения)");
        String userInput = IO.getInputString();
        return userInput.trim().equalsIgnoreCase("да");
    }
}
