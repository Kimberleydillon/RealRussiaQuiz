package com.example.realrussiaquiz.model;

import java.util.Arrays;

import static com.example.realrussiaquiz.model.Question.QuestionType.RADIO;
import static com.example.realrussiaquiz.model.Question.QuestionType.TEXT;

/**
 * Created by kdillon on 2018-02-01.
 */
//This is the question blueprint. It is used to make new question objects.
public class Question {
    //these are all the variables used in the construction of a question.
    // there is the question text and the types of questions.
    private String questionText;
    private QuestionType type;
    //these are the answers
    private String textAnswer;
    private int[] radioAnswer;
    //this is the questions choices
    private String[] questionChoices;
    //whether or not to use dark theme
    private boolean isDark;
    //which background color
    private int backgroundColor;



    //the question types
    public enum QuestionType {
        RADIO, CHECK_BOX, TEXT
    }

    //<editor-fold desc="Constructors">
    public Question(String questionText, QuestionType type, String[] questionChoices, int[] radioAnswer, boolean isDark, int backgroundColor) {
        this.questionText = questionText;
        this.type = type;
        this.questionChoices = questionChoices;
        this.radioAnswer = radioAnswer;
        this.isDark = isDark;
        this.backgroundColor = backgroundColor;
    }

    public Question(String questionText, String textAnswer, boolean isDark, int backgroundColor) {
        this.questionText = questionText;
        this.type = TEXT;
        this.textAnswer = textAnswer;
        this.isDark = isDark;
        this.backgroundColor = backgroundColor;
        isCorrect(textAnswer);
    }

    //</editor-fold>

    public boolean isCorrect(String answer) {
        if (type != TEXT) {
            return false;
        } else if (answer.equalsIgnoreCase("Bandy")  || answer.equalsIgnoreCase("Hockey")) {
            return true;
        }
        return answer.equalsIgnoreCase(textAnswer);
    }

    public boolean isCorrect(int [] answers){
        if (type == TEXT) {
            return false;
            } else if (type == RADIO) {
                if (Arrays.equals(answers, radioAnswer)) {
                    return true;
                }else{
                    return false;
            }
        }
        return false;
    }


    //<editor-fold desc="Getters and Setters">
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public int[] getRadioAnswer() {
        return radioAnswer;
    }

    public void setRadioAnswer(int[] radioAnswer) {
        this.radioAnswer = radioAnswer;
    }

    public boolean isDark() {
        return isDark;
    }

    public void setDark(boolean dark) {
        isDark = dark;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String[] getQuestionChoices() {
        return questionChoices;
    }

    public void setQuestionChoices(String[] questionChoices) {
        this.questionChoices = questionChoices;
    }
    //</editor-fold>


    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                ", type=" + type +
                ", textAnswer='" + textAnswer + '\'' +
                ", radioAnswer=" + Arrays.toString(radioAnswer) +
                ", isDark=" + isDark +
                ", backgroundColor=" + backgroundColor +
                '}';
    }
}


