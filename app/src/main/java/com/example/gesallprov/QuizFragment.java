package com.example.gesallprov;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class QuizFragment extends Fragment implements View.OnClickListener {

    private TextView tvTotalQ;
    private TextView tvQuestion;
    private Button answerABtn, answerBBtn, answerCBtn, answerDBtn, submitBtn;

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
        submitBtn = view.findViewById(R.id.submitBtn);

        answerABtn.setOnClickListener(this);
        answerBBtn.setOnClickListener(this);
        answerCBtn.setOnClickListener(this);
        answerDBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        tvTotalQ.setText("Total questions: " + totalQuestions);

        newQuestion();

        return view;
    }

    @Override
    public void onClick(View v) {
        answerABtn.setBackgroundColor(Color.WHITE);
        answerBBtn.setBackgroundColor(Color.WHITE);
        answerCBtn.setBackgroundColor(Color.WHITE);
        answerDBtn.setBackgroundColor(Color.WHITE);

        Button clickedBtn = (Button) v;
        if (clickedBtn.getId() == R.id.submitBtn) {
            int selectedAnswerIndex = getSelectedAnswerIndex();
            if (selectedAnswerIndex != -1) {
                methodScores[AnswerQuestion.answerMappings[currentQuestionsIndex][selectedAnswerIndex]]++;
                currentQuestionsIndex++;
                newQuestion();
            }
        } else {
            selectedAnswer = clickedBtn.getText().toString();
            clickedBtn.setBackgroundColor(Color.rgb(55, 0, 179));
        }
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

        answerABtn.setText(choices.length > 0 ? choices[0] : "");
        answerBBtn.setText(choices.length > 1 ? choices[1] : "");
        answerCBtn.setText(choices.length > 2 ? choices[2] : "");
        answerDBtn.setText(choices.length > 3 ? choices[3] : "");

        answerABtn.setVisibility(choices.length > 0 ? View.VISIBLE : View.GONE);
        answerBBtn.setVisibility(choices.length > 1 ? View.VISIBLE : View.GONE);
        answerCBtn.setVisibility(choices.length > 2 ? View.VISIBLE : View.GONE);
        answerDBtn.setVisibility(choices.length > 3 ? View.VISIBLE : View.GONE);
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
