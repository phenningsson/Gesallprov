package com.example.gesallprov;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizFragment extends Fragment implements View.OnClickListener {

    private TextView tvTotalQ;
    private TextView tvQuestion;
    private Button answerABtn, answerBBtn, answerCBtn, answerDBtn, answerEBtn, answerFBtn,
            answerGBtn, answerHBtn, answerIBtn, submitBtn;

    private int totalQuestions = AnswerQuestion.question.length;
    private int currentQuestionsIndex = 0;
    private String selectedAnswer = "";
    private int[] methodScores = new int[12]; // Updated for the number of methods

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_quiz, container, false);

        tvTotalQ = view.findViewById(R.id.tvTotalQ);
        tvQuestion = view.findViewById(R.id.tvQuestion);
        answerABtn = view.findViewById(R.id.answerABtn);
        answerBBtn = view.findViewById(R.id.answerBBtn);
        answerCBtn = view.findViewById(R.id.answerCBtn);
        answerDBtn = view.findViewById(R.id.answerDBtn);
        answerEBtn = view.findViewById(R.id.answerEBtn);
        answerFBtn = view.findViewById(R.id.answerFBtn);
        answerGBtn = view.findViewById(R.id.answerGBtn);
        answerHBtn = view.findViewById(R.id.answerHBtn);
        answerIBtn = view.findViewById(R.id.answerIBtn);
        submitBtn = view.findViewById(R.id.submitBtn);

        answerABtn.setOnClickListener(this);
        answerBBtn.setOnClickListener(this);
        answerCBtn.setOnClickListener(this);
        answerDBtn.setOnClickListener(this);
        answerEBtn.setOnClickListener(this);
        answerFBtn.setOnClickListener(this);
        answerGBtn.setOnClickListener(this);
        answerHBtn.setOnClickListener(this);
        answerIBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        tvTotalQ.setText("Total questions: " + totalQuestions);

        newQuestion();

        return view;
    }

    @Override
    public void onClick(View v) {
        resetButtonBackgrounds();

        Button clickedBtn = (Button) v;
        if (clickedBtn.getId() == R.id.submitBtn) {
            int selectedAnswerIndex = getSelectedAnswerIndex();
            if (selectedAnswerIndex != -1) {
                methodScores[AnswerQuestion.answerMappings[currentQuestionsIndex][selectedAnswerIndex]]++;
                currentQuestionsIndex++;
                newQuestion();
            } else {
                Toast.makeText(getActivity(), "Please select an answer before submitting", Toast.LENGTH_SHORT).show();
            }
        } else {
            selectedAnswer = clickedBtn.getText().toString();
            clickedBtn.setBackgroundColor(Color.rgb(55, 0, 179));
        }
    }

    private void resetButtonBackgrounds() {
        answerABtn.setBackgroundColor(Color.WHITE);
        answerBBtn.setBackgroundColor(Color.WHITE);
        answerCBtn.setBackgroundColor(Color.WHITE);
        answerDBtn.setBackgroundColor(Color.WHITE);
        answerEBtn.setBackgroundColor(Color.WHITE);
        answerFBtn.setBackgroundColor(Color.WHITE);
        answerGBtn.setBackgroundColor(Color.WHITE);
        answerHBtn.setBackgroundColor(Color.WHITE);
        answerIBtn.setBackgroundColor(Color.WHITE);
    }

    private int getSelectedAnswerIndex() {
        if (selectedAnswer.equals(answerABtn.getText().toString())) {
            return 0;
        } else if (selectedAnswer.equals(answerBBtn.getText().toString())) {
            return 1;
        } else if (selectedAnswer.equals(answerCBtn.getText().toString())) {
            return 2;
        } else if (selectedAnswer.equals(answerDBtn.getText().toString())) {
            return 3;
        } else if (selectedAnswer.equals(answerEBtn.getText().toString())) {
            return 4;
        } else if (selectedAnswer.equals(answerFBtn.getText().toString())) {
            return 5;
        } else if (selectedAnswer.equals(answerGBtn.getText().toString())) {
            return 6;
        } else if (selectedAnswer.equals(answerHBtn.getText().toString())) {
            return 7;
        } else if (selectedAnswer.equals(answerIBtn.getText().toString())) {
            return 8;
        } else {
            return -1;
        }
    }

    private void newQuestion() {
        if (currentQuestionsIndex == totalQuestions) {
            finishQuiz();
            return;
        }

        tvQuestion.setText(AnswerQuestion.question[currentQuestionsIndex]);
        String[] choices = AnswerQuestion.choices[currentQuestionsIndex];

        Button[] buttons = {answerABtn, answerBBtn, answerCBtn, answerDBtn, answerEBtn, answerFBtn, answerGBtn, answerHBtn, answerIBtn};

        for (int i = 0; i < buttons.length; i++) {
            if (i < choices.length) {
                buttons[i].setText(choices[i]);
                buttons[i].setVisibility(View.VISIBLE);
            } else {
                buttons[i].setVisibility(View.GONE);
            }
        }
        selectedAnswer = ""; // Reset selected answer for new question
    }

    private void finishQuiz() {
        StringBuilder resultMessage = new StringBuilder();
        resultMessage.append("Living Labs: ")
                .append((methodScores[0] * 100) / totalQuestions)
                .append("%\nWorld Café: ")
                .append((methodScores[1] * 100) / totalQuestions)
                .append("%\nEnquêteren: ")
                .append((methodScores[2] * 100) / totalQuestions)
                .append("%\nBurgerjury: ")
                .append((methodScores[3] * 100) / totalQuestions)
                .append("%\nKlankbord Groep: ")
                .append((methodScores[4] * 100) / totalQuestions)
                .append("%\nInspraak Bijeenkomst: ")
                .append((methodScores[5] * 100) / totalQuestions)
                .append("%\nStraat Interviews: ")
                .append((methodScores[6] * 100) / totalQuestions)
                .append("%\nSwipocratie: ")
                .append((methodScores[7] * 100) / totalQuestions)
                .append("%\nInteractieve Internet Omgeving: ")
                .append((methodScores[8] * 100) / totalQuestions)
                .append("%\nInteractieve Scenariobouw: ")
                .append((methodScores[9] * 100) / totalQuestions)
                .append("%\nKeukentafel Gesprekken: ")
                .append((methodScores[10] * 100) / totalQuestions)
                .append("%\nPhotovoice: ")
                .append((methodScores[11] * 100) / totalQuestions)
                .append("%");

        // Show results in the new ResultFragment
        ResultFragment resultFragment = ResultFragment.newInstance(resultMessage.toString());
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, resultFragment)
                .commit();
    }
}
