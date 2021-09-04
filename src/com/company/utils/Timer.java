package com.company.utils;

import java.util.Date;

public class Timer {

    private long startTime;
    private long stopTime;

    public Timer(){
        Date date = new Date();
        startTime = date.getTime();
        IO.println("Таймер запущен...", IO.FontColor.ANSI_BLUE);
    }

    private void stop(){
        Date date = new Date();
        stopTime = date.getTime();

    }

    public void showResult(){
        stop();
        long duration = stopTime - startTime;
        IO.println("Время, затраченное на поиск, мс.: " + duration, IO.FontColor.ANSI_BLUE);
    }


}
