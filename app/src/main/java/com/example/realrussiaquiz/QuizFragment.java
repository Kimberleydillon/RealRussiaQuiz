package com.example.realrussiaquiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuizFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private int questionNumber;

    private OnFragmentInteractionListener mListener;

    public QuizFragment() {
        Log.d("QuizFragment", "QuizFragment Constructor");
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment QuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizFragment newInstance(int param1) {
        Log.d("QuizFragment", "newInstance");
        QuizFragment fragment = new QuizFragment();
        fragment.questionNumber = param1;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("QuizFragment", "onCreate");
        Log.d("abc", String.valueOf(questionNumber));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("QuizFragment", "onCreateView");
        //Sets root view
        View rootView = inflater.inflate(R.layout.fragment_quiz, container, false);
        //In charge of setting up view only after rootview is returned and fragment instantiated.
        setupView(rootView, questionNumber);

// There is no view until rootview is returned
        return rootView;
    }

    public void setupView(View rootView, int questionNumber) {
        RadioGroup radioGroup = rootView.findViewById(R.id.radiogroup);
        RelativeLayout editText = (RelativeLayout) rootView.findViewById(R.id.edittext);
        LinearLayout checkBoxes = (LinearLayout) rootView.findViewById(R.id.checkboxes);
        switch (questionNumber) {
            case 0:
                setQuestion(rootView, "How many military casualties did  the Soviet Union suffer in WW2?");
                setRadioButtonAnswers(rootView, "400,000", "800,000", "10,000", "11,000,000");
                return;
            case 1:
                setBackground(rootView, "red");
                setQuestion(rootView, "How many different ethnic groups live in Russia?");
                setRadioButtonAnswers(rootView, "186", "45", "15", "110");
                return;
            case 2:
                radioGroup.setVisibility(View.GONE);
                editText.setVisibility(View.VISIBLE);
                setBackground(rootView, "white");
                setQuestion(rootView, "What is the national sport of Russia?");
                return;
            case 3:
                radioGroup.setVisibility(View.VISIBLE);
                editText.setVisibility(View.GONE);
                setQuestion(rootView, "Which is a list of Russia's common eaten cuisine?");
                setRadioButtonAnswers(rootView, "okroshka, shchi, kvass, pelmeni", "tiblitsa, pogaca, xleb, strudla", "broscht, perogies, kapusniak, rosolnk", "stapici, pletenice, kifle, djevreci");
                return;
            case 4:
                setBackground(rootView, "red");
                setQuestion(rootView, "What is the average yearly salary in Russia?");
                setRadioButtonAnswers(rootView," $40,000 USD", "$20,000", "$15,000", "$8,0000");
                return;
            case 5:
                setBackground(rootView, "white");
                setQuestion(rootView, "Who was Russia's last tsar?");
                setRadioButtonAnswers(rootView, "Catherine the Great", "Nicholas II", "Alexander III", " Yaroslav I");
                return;
            case 6:
                setQuestion(rootView, "What is a popular Russian past time?");
                setRadioButtonAnswers(rootView, "Cooking", "Going to the movies", "Attending theater events", "the art of sorcery");
                return;
            case 7:
                setBackground(rootView, "red");
                setQuestion(rootView, "How many theatres are there in Saint Petersburg?");
                setRadioButtonAnswers(rootView, "55", "400", "180", "23");
                return;
            case 8:
                setBackground(rootView, "white");
                radioGroup.setVisibility(View.GONE);
                checkBoxes.setVisibility(View.VISIBLE);
                setQuestion(rootView, " What innovations have been invented by Russians?");
                /** Change these to checkboxes for multiple answers **/
                setCheckboxAnswers(rootView, "vodka, television, film school, paratrooping", "rollercoaster, yacht club, rebar, beehive frame, AK-47", "radiator, ac transformer, headlamp, vitamins", "electric submarine, periodic table of elements, solar cell, fire fighting foam ");
                return;
            case 9:
                setQuestion(rootView, "What is Russia's largest industry?");
                setRadioButtonAnswers(rootView, "Natural Gas", "Oil", "Lumber", "Vodka");
        }
    }

    public void setQuestion(View rootView, String question) {
        Log.d("QuizFragment", "setQuestion");
        TextView questionView = (TextView) rootView.findViewById(R.id.question);
        questionView.setText(question);
    }

    public void setRadioButtonAnswers(View rootView, String answer1, String answer2, String answer3, String answer4) {
        Log.d("QuizFragment", "setRadioButtonAnswers");
        RadioButton answerView1 = (RadioButton) rootView.findViewById(R.id.ra1);
        answerView1.setText(answer1);
        RadioButton answerView2 = (RadioButton) rootView.findViewById(R.id.ra2);
        answerView2.setText(answer2);
        RadioButton answerView3 = (RadioButton) rootView.findViewById(R.id.ra3);
        answerView3.setText(answer3);
        RadioButton answerView4 = (RadioButton) rootView.findViewById(R.id.ra4);
        answerView4.setText(answer4);
    }

    public void setCheckboxAnswers (View rootView, String answer1, String answer2, String answer3, String answer4 ) {
        Log.d("QuizFragment", "setCheckboxAnswers");
        CheckBox answerView1 = (CheckBox) rootView.findViewById(R.id.a1);
        answerView1.setText(answer1);
        CheckBox answerView2 = (CheckBox) rootView.findViewById(R.id.a2);
        answerView2.setText(answer2);
        CheckBox answerView3 = (CheckBox) rootView.findViewById(R.id.a3);
        answerView3.setText(answer3);
        CheckBox answerView4 = (CheckBox) rootView.findViewById(R.id.a4);
        answerView4.setText(answer4);
    }


    public void setBackground(View rootview, String color){
        int redBackgroundColor = ContextCompat.getColor(getContext(), R.color.red_view);
        int whiteBackgroundColor = ContextCompat.getColor(getContext()got s, R.color.white_view);
        if (color == "red"){
            rootview.setBackgroundColor(redBackgroundColor);
        }else if ( color == "white"){
            rootview.setBackgroundColor(whiteBackgroundColor);
        }
    }
    /** method that checks which radio button is clicked and then verifies if it is the right answer. If/else statement **/
//    public void onRadioButtonClicked(View rootview) {
//        boolean checked = (())
//    }

    //TODO: check if right answer.
    //TODO: Change background color method


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        Log.d("QuizFragment", "onButtonPressed");
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("QuizFragment", "onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("QuizFragment", "onDetach");
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
