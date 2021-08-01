package com.company;

public class Question {

    private String text;
    private String[] answerVariants;
    private int rightAnswer;

    public Question(String text, String[] answerVariants, int rightAnswer){
        this.text = text;
        this.answerVariants = answerVariants;
        this.rightAnswer = rightAnswer;
    }

    public String getText(){
        return text;
    }

    public String[] getAnswerVariants(){
        return answerVariants;
    }

    public boolean checkSuccessfulResult(int userAnswer){
        return userAnswer == rightAnswer;
    }

}
