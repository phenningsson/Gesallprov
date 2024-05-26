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

    // Declaraties van TextViews en Buttons
    private TextView tvTotalQ;
    private TextView tvQuestion;
    private Button answerABtn, answerBBtn, answerCBtn, answerDBtn, answerEBtn, answerFBtn,
            answerGBtn, answerHBtn, answerIBtn, answerJBtn, submitBtn, backBtn;

    // Variabelen voor de totale vragen, huidige vraagindex, geselecteerde antwoord en methodescores
    private int totalQuestions = AnswerQuestion.question.length;
    private int currentQuestionsIndex = 0;
    private String selectedAnswer = "";
    private int[] methodScores = new int[12]; // Update for the number of methods (12 for now)
    private String[] selectedAnswers = new String[totalQuestions]; // To store selected answers

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate het layout voor dit fragment
        view = inflater.inflate(R.layout.fragment_quiz, container, false);

        // Initialiseer TextViews en Buttons
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
        answerJBtn = view.findViewById(R.id.answerJBtn);
        submitBtn = view.findViewById(R.id.submitBtn);
        backBtn = view.findViewById(R.id.backBtn);

        // Zet OnClickListeners voor de buttons
        answerABtn.setOnClickListener(this);
        answerBBtn.setOnClickListener(this);
        answerCBtn.setOnClickListener(this);
        answerDBtn.setOnClickListener(this);
        answerEBtn.setOnClickListener(this);
        answerFBtn.setOnClickListener(this);
        answerGBtn.setOnClickListener(this);
        answerHBtn.setOnClickListener(this);
        answerIBtn.setOnClickListener(this);
        answerJBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);

        // Initialiseer de weergave van het huidige vraagnummer
        tvTotalQ.setText("Vraag 1 van " + totalQuestions);

        newQuestion();

        return view;
    }

    @Override
    public void onClick(View v) {
        // Reset de achtergrond van de buttons
        resetButtonBackgrounds();

        Button clickedBtn = (Button) v;
        if (clickedBtn.getId() == R.id.submitBtn) {
            int selectedAnswerIndex = getSelectedAnswerIndex();
            if (selectedAnswerIndex != -1) {
                selectedAnswers[currentQuestionsIndex] = selectedAnswer; // Store selected answer

                // Werk de methodescores bij op basis van het geselecteerde antwoord
                methodScores[0] += MethodWeightings.livingLabsWeights[currentQuestionsIndex][selectedAnswerIndex];
                methodScores[1] += MethodWeightings.worldCafeWeights[currentQuestionsIndex][selectedAnswerIndex];
                methodScores[2] += MethodWeightings.enqueterenWeights[currentQuestionsIndex][selectedAnswerIndex];
                methodScores[3] += MethodWeightings.burgerjuryWeights[currentQuestionsIndex][selectedAnswerIndex];
                methodScores[4] += MethodWeightings.klankbordgroepWeights[currentQuestionsIndex][selectedAnswerIndex];
                methodScores[5] += MethodWeightings.inspraakbijeenkomstWeights[currentQuestionsIndex][selectedAnswerIndex];
                methodScores[6] += MethodWeightings.straatinterviewsWeights[currentQuestionsIndex][selectedAnswerIndex];
                methodScores[7] += MethodWeightings.scenariobouwWeights[currentQuestionsIndex][selectedAnswerIndex];
                methodScores[8] += MethodWeightings.interactieveInternetomgevingWeights[currentQuestionsIndex][selectedAnswerIndex];
                methodScores[9] += MethodWeightings.keukentafelgesprekkenWeights[currentQuestionsIndex][selectedAnswerIndex];
                methodScores[10] += MethodWeightings.photovoiceWeights[currentQuestionsIndex][selectedAnswerIndex];
                methodScores[11] += MethodWeightings.swipocratieWeights[currentQuestionsIndex][selectedAnswerIndex];

                currentQuestionsIndex++;
                newQuestion();
            } else {
                Toast.makeText(getActivity(), "Voer antwoord in", Toast.LENGTH_SHORT).show();
            }
        } else if (clickedBtn.getId() == R.id.backBtn) {
            if (currentQuestionsIndex > 0) {
                currentQuestionsIndex--;
                loadPreviousAnswer();
                newQuestion();
            } else {
                Toast.makeText(getActivity(), "Dit is de eerste vraag", Toast.LENGTH_SHORT).show();
            }
        } else {
            selectedAnswer = clickedBtn.getText().toString();
            clickedBtn.setBackgroundColor(Color.rgb(0, 0, 0));
            clickedBtn.setTextColor(Color.rgb(255, 255, 255));
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
        answerJBtn.setBackgroundColor(Color.WHITE);

        answerABtn.setTextColor(Color.BLACK);
        answerBBtn.setTextColor(Color.BLACK);
        answerCBtn.setTextColor(Color.BLACK);
        answerDBtn.setTextColor(Color.BLACK);
        answerEBtn.setTextColor(Color.BLACK);
        answerFBtn.setTextColor(Color.BLACK);
        answerGBtn.setTextColor(Color.BLACK);
        answerHBtn.setTextColor(Color.BLACK);
        answerIBtn.setTextColor(Color.BLACK);
        answerJBtn.setTextColor(Color.BLACK);
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
        } else if (selectedAnswer.equals(answerJBtn.getText().toString())) {
            return 9;
        } else {
            return -1;
        }
    }

    private void newQuestion() {
        if (currentQuestionsIndex == totalQuestions) {
            finishQuiz();
            return;
        }

        tvTotalQ.setText("Vraag " + (currentQuestionsIndex + 1) + " van " + totalQuestions);

        tvQuestion.setText(AnswerQuestion.question[currentQuestionsIndex]);
        String[] choices = AnswerQuestion.choices[currentQuestionsIndex];

        Button[] buttons = {answerABtn, answerBBtn, answerCBtn, answerDBtn, answerEBtn, answerFBtn, answerGBtn, answerHBtn, answerIBtn, answerJBtn};

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

    private void loadPreviousAnswer() {
        if (selectedAnswers[currentQuestionsIndex] != null) {
            selectedAnswer = selectedAnswers[currentQuestionsIndex];
            Button[] buttons = {answerABtn, answerBBtn, answerCBtn, answerDBtn, answerEBtn, answerFBtn, answerGBtn, answerHBtn, answerIBtn, answerJBtn};

            for (Button button : buttons) {
                if (button.getText().toString().equals(selectedAnswer)) {
                    button.setBackgroundColor(Color.rgb(0, 0, 0));
                    button.setTextColor(Color.rgb(255, 255, 255));
                    break;
                }
            }
        }
    }

    private void finishQuiz() {
        // Stel een bericht samen met de resultaten van de quiz
        StringBuilder resultMessage = new StringBuilder();
        resultMessage.append("Living Labs: ")
                .append((methodScores[0] * 100) / MethodWeightings.maxPointsLivingLabs)
                .append("%\nWorld Café: ")
                .append((methodScores[1] * 100) / MethodWeightings.maxPointsWorldCafe)
                .append("%\nEnquêteren: ")
                .append((methodScores[2] * 100) / MethodWeightings.maxPointsEnqueteren)
                .append("%\nBurgerjury: ")
                .append((methodScores[3] * 100) / MethodWeightings.maxPointsBurgerjury)
                .append("%\nKlankbord Groep: ")
                .append((methodScores[4] * 100) / MethodWeightings.maxPointsKlankbordgroep)
                .append("%\nInspraak Bijeenkomst: ")
                .append((methodScores[5] * 100) / MethodWeightings.maxPointsInspraakbijeenkomst)
                .append("%\nStraat Interviews: ")
                .append((methodScores[6] * 100) / MethodWeightings.maxPointsStraatinterviews)
                .append("%\nScenariobouw: ")
                .append((methodScores[7] * 100) / MethodWeightings.maxPointsScenariobouw)
                .append("%\nInteractieve Internet Omgeving: ")
                .append((methodScores[8] * 100) / MethodWeightings.maxPointsInteractieveInternetomgeving)
                .append("%\nKeukentafel Gesprekken: ")
                .append((methodScores[9] * 100) / MethodWeightings.maxPointsKeukentafelgesprekken)
                .append("%\nPhotovoice: ")
                .append((methodScores[10] * 100) / MethodWeightings.maxPointsPhotovoice)
                .append("%\nSwipocratie: ")
                .append((methodScores[11] * 100) / MethodWeightings.maxPointsSwipocratie)
                .append("%");

        // Toon de resultaten in het nieuwe ResultFragment
        ResultFragment resultFragment = ResultFragment.newInstance(resultMessage.toString());
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, resultFragment)
                .commit();
    }
}
