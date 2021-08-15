package com.company;

import java.util.Scanner;

public class IOController {

    public enum FontColor {

        ANSI_RESET("\u001B[0m"),
        ANSI_BLUE("\u001B[34m"),
        ANSI_RED("\u001B[31m"),
        ANSI_GREEN("\u001B[32m");

        private String code;

        FontColor(String code){
            this.code = code;
        }
        public String getCode(){ return code;}
    }

    public static void println(){
        System.out.println();
    }

    public static void println(String text){

        print(text);
        System.out.println();

    }

    public static void println(String text, FontColor fontColor){

        print(text,fontColor);
        System.out.println();

    }

    public static void print(String text){

        System.out.print(text);

    }

    public static void print(String text, FontColor fontColor){

        FontColor fontColorReset = FontColor.ANSI_RESET;
        System.out.print(fontColor.getCode() + text + fontColorReset.getCode());

    }

    public static long getInputInt() {

        long userInput = getInputLong();
        return (int)userInput;

    }

    public static long getInputLong() {

        String userInput;

        boolean is_digital = false;
        do {
            userInput = getInputString();
            if (userInput.matches("[-+]?\\d+")) {
                is_digital = true;
            }else {
                System.out.println(FontColor.ANSI_RED.getCode() + "Пожалуйста, введите число" + FontColor.ANSI_RESET.getCode());
            }
        } while (!is_digital);

        return Long.parseLong(userInput);
    }


    public static String getInputString() {

        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();

    }




}
