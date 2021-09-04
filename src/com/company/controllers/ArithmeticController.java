package com.company.controllers;

import com.company.models.*;
import com.company.utils.IO;

import java.io.*;

public class ArithmeticController {

    public String makeChoice() {
        IO.println("1. Ввести пример с клавиатуры", IO.FontColor.ANSI_BLUE);
        IO.println("2. Выбрать файл", IO.FontColor.ANSI_BLUE);
        return IO.getInputString();
    }


    public ArithmeticBox manualInput() {

        ArithmeticBox arithmeticBox = new ArithmeticBox();

        IO.println("Введите пример в формате A [+-*/] B:", IO.FontColor.ANSI_BLUE);
        String userInput = IO.getInputString();
        arithmeticBox.addExercise(userInput);

        return arithmeticBox;
    }

    public ArithmeticBox fileInput() {

        ArithmeticBox arithmeticBox = new ArithmeticBox();

        IO.println("Введите имя файла:", IO.FontColor.ANSI_BLUE);
        String fileName = IO.getInputString();

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                arithmeticBox.addExercise(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arithmeticBox;
    }
}
