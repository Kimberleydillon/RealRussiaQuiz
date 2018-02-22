package com.example.realrussiaquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.realrussiaquiz.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_start);
    }

    public void startQuiz(View view) {

        //set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment show be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), makeQuestions());

        //Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
    }

    private List<Question> makeQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "How many military casualties did  the Soviet Union suffer in WW2?",
                Question.QuestionType.RADIO,
                new String[]{"400,000", "800,000", "10,000", "11,000,000"},
                new int[]{3},
                false,
                R.color.colorPrimary));
        questions.add(new Question(
                "How many different ethnic groups live in Russia?",
                Question.QuestionType.RADIO,
                new String[]{"186", "45", "15", "110"},
                new int[]{0},
                false, R.color.red_view));
        questions.add(new Question(
                "What is the national sport of Russia?",
                "Bandy",
                true,
                R.color.white_view));
        questions.add(new Question(
                "Which is a list of Russia's common eaten cuisine?",
                Question.QuestionType.RADIO, new String[]{"okroshka, shchi, kvass, pelmeni", "tiblitsa, pogaca, xleb, strudla", "broscht, perogies, kapusniak, rosolnk", "stapici, pletenice, kifle, djevreci"},
                new int[]{0},
                false,
                R.color.colorPrimary));
        questions.add(new Question(
                "What is the average yearly salary in Russia?",
                Question.QuestionType.RADIO, new String[]{"$40,000 USD", "$20,000", "$15,000", "$8,0000"},
                new int[]{2},
                false, R.color.red_view));
        questions.add(new Question("How many theatres are there in Saint Petersburg?",
                Question.QuestionType.RADIO,
                new String[]{"55", "400", "180", "23"},
                new int[]{2},
                true, R.color.white_view));
        questions.add(new Question("Who was Russia's last tsar?",
                Question.QuestionType.RADIO,
                new String[]{"Catherine the Great", "Nicholas II", "Alexander III", "Yaroslav I"},
                new int[]{1},
                false, R.color.colorPrimary));
        questions.add(new Question("What is a popular Russian past time?",
                Question.QuestionType.RADIO,
                new String[]{"Cooking", "Going to the movies", "Attending theater events", "the art of sorcery"},
                new int[]{2},
                false, R.color.red_view));
        questions.add(new Question("What innovations have been invented by Russians",
                Question.QuestionType.CHECK_BOX,
                new String[]{"vodka, television, film school, paratrooping", "rollercoaster, yacht club, rebar, beehive frame, AK-47", "radiator, ac transformer, headlamp, vitamins", "electric submarine, periodic table of elements, solar cell, fire fighting foam"},
                new int[]{0,1,2,3},
                true, R.color.white_view));
        questions.add(new Question("What is Russia's largest industry?",
                Question.QuestionType.RADIO,
                new String[]{"Natural Gas", "Oil", "Lumber", "Vodka"},
                new int[]{0,1,2,3},
                false, R.color.colorPrimary));
        return questions;
    }

}