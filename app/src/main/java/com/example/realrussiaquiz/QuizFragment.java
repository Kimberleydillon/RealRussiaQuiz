package com.example.realrussiaquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

        // There is no view until rootview is returned.
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
            Log.e(TAG, "invalid answers");
            return;
        }

        Log.d("QuizFragment", "setRadioButtonAnswers");
        RadioGroup group = rootView.findViewById(R.id.radiogroup);
        RadioButton answerView1 = rootView.findViewById(R.id.ra1);
        answerView1.setText(answers[0]);
        RadioButton answerView2 = rootView.findViewById(R.id.ra2);
        answerView2.setText(answers[1]);
        RadioButton answerView3 = rootView.findViewById(R.id.ra3);
        answerView3.setText(answers[2]);
        RadioButton answerView4 = rootView.findViewById(R.id.ra4);
        answerView4.setText(answers[3]);

        //Set an on Change listener
        group.setOnCheckedChangeListener(radioChangeListener);
    }

    public void setCheckboxAnswers(View rootView, String[] answers) {
        RadioGroup radioButtons = rootView.findViewById(R.id.radiogroup);
        LinearLayout checkboxesLayout = rootView.findViewById(R.id.checkboxes);
        Button submitButton = rootView.findViewById(R.id.checkboxSubmitButton);
        checkboxesLayout.setVisibility(View.VISIBLE);
        radioButtons.setVisibility(View.GONE);
        if (answers == null || answers.length != 4) {
            Log.e("quiz fragment", "invalid answers");
            return;
        }
        Log.d("QuizFragment", "setCheckboxAnswers");
        final CheckBox answerView1 = rootView.findViewById(R.id.a1);
        answerView1.setText(answers[0]);
        final CheckBox answerView2 = rootView.findViewById(R.id.a2);
        answerView2.setText(answers[1]);
        final CheckBox answerView3 = rootView.findViewById(R.id.a3);
        answerView3.setText(answers[2]);
        final CheckBox answerView4 = rootView.findViewById(R.id.a4);
        answerView4.setText(answers[3]);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (answerView1.isChecked() && answerView2.isChecked() && answerView3.isChecked() && answerView4.isChecked()) {
                    Log.d(TAG, "All checkboxes are Checked");
                    Toast.makeText(getContext(), "\ud83d\udc82" + " Mолодец!" + " Good work!" + " \ud83c\udf5e", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d(TAG, "not all checkboxes are checked");
                    Toast.makeText(getContext(), "\ud83d\ude45" + " Oй, oшибка " + " Incorrect" + " \ud83d\udeab", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public void setTextAnswers(View rootView) {
        Log.d(TAG, "setTextAnswers");
        RelativeLayout editTextLayout = rootView.findViewById(R.id.edittextlayout);
        RadioGroup radioButtons = rootView.findViewById(R.id.radiogroup);
        Button submitButton = rootView.findViewById(R.id.editTextSubmitButton);
        final EditText editText = rootView.findViewById(R.id.edittext);
        radioButtons.setVisibility(View.GONE);
        editTextLayout.setVisibility(View.VISIBLE);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void  onClick (View v) {
                Log.v("EditText", editText.getText().toString());
                String userInput = editText.getText().toString();
                question.isCorrect(userInput);
                if (question.isCorrect(userInput) == true){
                    Toast.makeText(getContext(), "\ud83d\udc82" + " Mолодец!" + " Good work!" + " \ud83c\udf5e" + "\n Bandy (ball hockey) is the most ideal answer but \n Hockey will also be accepted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "\ud83d\ude45" + " Oй, oшибка " + " Incorrect" + " \ud83d\udeab", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    RadioGroup.OnCheckedChangeListener radioChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int radioButtonId) {
            Log.d(TAG, "Listening?");
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
            question.isCorrect(new int[]{answer});
            if (question.isCorrect(new int[]{answer}) == true) {

                Toast.makeText(getContext(), "\ud83d\udc82" + " Mолодец!" + " Good work!" + " \ud83c\udf5e", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "\ud83d\ude45" + " Oй, oшибка " + " Incorrect" + " \ud83d\udeab", Toast.LENGTH_SHORT).show();
            }
            Log.d(TAG, "" + question.isCorrect(new int[]{answer}));
        }
    };

}
