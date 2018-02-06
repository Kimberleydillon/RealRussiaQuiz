package com.example.realrussiaquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.realrussiaquiz.model.Question;


public class QuizFragment extends Fragment {
    private static final String TAG = QuizFragment.class.getName();
    private Question question;

    public QuizFragment() {
        Log.d("QuizFragment", "QuizFragment Constructor");
        // Required empty public constructor
    }

    public static QuizFragment newInstance(Question question) {
        Log.d("QuizFragment", "newInstance");
        QuizFragment fragment = new QuizFragment();
        fragment.question = question;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");
        Log.d(TAG, question.toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView");
        //Sets root view
        View rootView;
        if (question.isDark()) {
            rootView = inflater.inflate(R.layout.fragment_quiz_dark, container, false);
        } else {
            rootView = inflater.inflate(R.layout.fragment_quiz, container, false);
        }
        //In charge of setting up view only after rootview is returned and fragment instantiated.
        setupView(rootView);

// There is no view until rootview is returned
        return rootView;
    }

    public void setupView(View rootView) {
        TextView questionView = rootView.findViewById(R.id.question);
        rootView.setBackgroundColor(ContextCompat.getColor(getContext(), question.getBackgroundColor()));
        questionView.setText(question.getQuestionText());
        switch (question.getType()) {
            case TEXT:
                setTextAnswers(rootView);
                break;
            case RADIO:
                setRadioButtonAnswers(rootView, question.getQuestionChoices());
                break;
            case CHECK_BOX:
                setCheckboxAnswers(rootView, question.getQuestionChoices());
                break;
        }
    }

    public void setRadioButtonAnswers(View rootView, String[] answers) {
        if (answers == null || answers.length != 4) {
            Log.e("quiz fragment", "invalid answers");
            return;
        }
        Log.d("QuizFragment", "setRadioButtonAnswers");
        RadioGroup group = rootView.findViewById(R.id.radiogroup);
        RadioButton answerView1 = (RadioButton) rootView.findViewById(R.id.ra1);
        answerView1.setText(answers[0]);
        RadioButton answerView2 = (RadioButton) rootView.findViewById(R.id.ra2);
        answerView2.setText(answers[1]);
        RadioButton answerView3 = (RadioButton) rootView.findViewById(R.id.ra3);
        answerView3.setText(answers[2]);
        RadioButton answerView4 = (RadioButton) rootView.findViewById(R.id.ra4);
        answerView4.setText(answers[3]);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int radioButtonId) {
                int answer = 0;
                switch (radioButtonId) {
                    case R.id.ra1:
                        answer = 0;
                        break;
                    case R.id.ra2:
                        answer = 1;
                        break;
                    case R.id.ra3:
                        answer = 2;
                        break;
                    case R.id.ra4:
                        answer = 3;
                        break;
                }
                Log.d("quiz fragment", String.format("answer %s,correct %s", answer, question.isCorrect(new int[]{answer})));
            }
        });
    }

    public void setCheckboxAnswers(View rootView, String[] answers) {
        RadioGroup radioButtons = rootView.findViewById(R.id.radiogroup);
        LinearLayout checkboxesLayout = rootView.findViewById(R.id.checkboxes);
        checkboxesLayout.setVisibility(View.VISIBLE);
        radioButtons.setVisibility(View.GONE);
        if (answers == null || answers.length != 4) {
            Log.e("quiz fragment", "invalid answers");
            return;
        }
        Log.d("QuizFragment", "setCheckboxAnswers");
        CheckBox answerView1 = (CheckBox) rootView.findViewById(R.id.a1);
        answerView1.setText(answers[0]);
        CheckBox answerView2 = (CheckBox) rootView.findViewById(R.id.a2);
        answerView2.setText(answers[1]);
        CheckBox answerView3 = (CheckBox) rootView.findViewById(R.id.a3);
        answerView3.setText(answers[2]);
        CheckBox answerView4 = (CheckBox) rootView.findViewById(R.id.a4);
        answerView4.setText(answers[3]);

    }

    public void onCheckboxClicked(View rootview){
        //is the view now checked?
        boolean checked = ((CheckBox) rootview).isChecked();
    }


    public void setTextAnswers (View rootView){
        Log.d( TAG, "setTextAndswers");
        RadioGroup radioButtons = rootView.findViewById(R.id.radiogroup);
        EditText inputAnswer = rootView.findViewById(R.id.edittext);
        inputAnswer.setVisibility(View.VISIBLE);
        radioButtons.setVisibility(View.GONE);

    }

}
