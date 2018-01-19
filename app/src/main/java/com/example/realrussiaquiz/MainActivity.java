package com.example.realrussiaquiz;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_start);

//        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
//        viewPager.setAdapter(new CustomPagerAdapter(this));
        //The Role of the MAinActivity in the code above is to just reference the ViewPager and set the CustomPager Adapter class that extends the PagerAdapter.
    }

    public void startQuiz(View view) {

        //set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager =  findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment show be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        //Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

    }
}
