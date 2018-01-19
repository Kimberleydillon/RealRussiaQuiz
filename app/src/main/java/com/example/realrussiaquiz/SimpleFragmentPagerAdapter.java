package com.example.realrussiaquiz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by kdillon on 2018-01-09.
 */

    public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

        public SimpleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

//    @Override
//    public Fragment getItem(String quiznumber) {
//        return quiznumber;
//    }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return QuizFragment.newInstance("1. ", "How many Military casualties did the Soviet Union suffer in WW2?");
            } else if (position == 1){
                return QuizFragment.newInstance("2", "How many different ethnic groups live in Russia?");
            } else {
                return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

