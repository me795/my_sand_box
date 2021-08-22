package com.company.utils;

import java.util.Date;

public class Timer {

    private long startTime;
    private long stopTime;

    public Timer(){
        Date date = new Date();
        startTime = date.getTime();
        IOController.println("Таймер запущен...", IOController.FontColor.ANSI_BLUE);
    }

    private void stop(){
        Date date = new Date();
        stopTime = date.getTime();

    }

    public void showResult(){
        stop();
        long duration = stopTime - startTime;
        IOController.println("Время, затраченное на поиск, мс.: " + duration, IOController.FontColor.ANSI_BLUE);
    }


}
