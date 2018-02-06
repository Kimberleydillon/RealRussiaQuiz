package com.example.realrussiaquiz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.realrussiaquiz.model.Question;

import java.util.List;

/**
 * Created by kdillon on 2018-01-09.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Question> questions;

    public SimpleFragmentPagerAdapter(FragmentManager fm, List<Question> questions) {
        super(fm);
        this.questions = questions;
    }

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return QuizFragment.newInstance(questions.get(position));
    }

    @Override
    public int getCount() {
        return questions.size();
    }
}

