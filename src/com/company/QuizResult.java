package com.company;

public class QuizResult {

    private int questionCounter;
    private int successCounter;

    public void countSuccessfulAnswer() {
        questionCounter++;
        successCounter++;
    }

    public void countFailedAnswer() {
        questionCounter++;
    }

    public int getQuestionCounter(){
        return questionCounter;
    }

    public int getSuccessCounter(){
        return successCounter;
    }

}
