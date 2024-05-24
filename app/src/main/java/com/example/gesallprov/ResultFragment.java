package com.example.gesallprov;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ResultFragment extends Fragment {

    private static final String ARG_RESULTS = "results";
    private String results;

    public ResultFragment() {
        // Required empty public constructor
    }

    public static ResultFragment newInstance(String results) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString(ARG_RESULTS, results);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            results = getArguments().getString(ARG_RESULTS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        TextView tvTopMethodName = view.findViewById(R.id.tvTopMethodName);
        ImageView ivTopMethodImage = view.findViewById(R.id.ivTopMethodImage);
        LinearLayout topMethodLayout = view.findViewById(R.id.topMethodLayout);

        TextView tvSecondMethodName = view.findViewById(R.id.tvSecondMethodName);
        ImageView ivSecondMethodImage = view.findViewById(R.id.ivSecondMethodImage);
        LinearLayout secondMethodLayout = view.findViewById(R.id.secondMethodLayout);

        TextView tvThirdMethodName = view.findViewById(R.id.tvThirdMethodName);
        ImageView ivThirdMethodImage = view.findViewById(R.id.ivThirdMethodImage);
        LinearLayout thirdMethodLayout = view.findViewById(R.id.thirdMethodLayout);

        LinearLayout lowerScoredMethodsLayout = view.findViewById(R.id.lowerScoredMethodsLayout);
        Button btnRestart = view.findViewById(R.id.btnRestart);
        Button btnMainMenu = view.findViewById(R.id.btnMainMenu);

        // Sort results
        List<Result> sortedResults = sortResults(results);

        if (sortedResults.size() > 0) {
            Result topResult = sortedResults.get(0);
            tvTopMethodName.setText(formatMethodName(topResult.getMethodName()) + ": " + topResult.getScore() + "%");
            ivTopMethodImage.setImageResource(getImageResource(topResult.getMethodName()));
            topMethodLayout.setBackgroundResource(getBorderResource(topResult.getMethodName()));
        }
        if (sortedResults.size() > 1) {
            Result secondResult = sortedResults.get(1);
            tvSecondMethodName.setText(formatMethodName(secondResult.getMethodName()) + ": " + secondResult.getScore() + "%");
            ivSecondMethodImage.setImageResource(getImageResource(secondResult.getMethodName()));
            secondMethodLayout.setBackgroundResource(getBorderResource(secondResult.getMethodName()));
        }
        if (sortedResults.size() > 2) {
            Result thirdResult = sortedResults.get(2);
            tvThirdMethodName.setText(formatMethodName(thirdResult.getMethodName()) + ": " + thirdResult.getScore() + "%");
            ivThirdMethodImage.setImageResource(getImageResource(thirdResult.getMethodName()));
            thirdMethodLayout.setBackgroundResource(getBorderResource(thirdResult.getMethodName()));
        }

        // Handle lower scored methods
        for (int i = 3; i < sortedResults.size(); i++) {
            Result result = sortedResults.get(i);
            TextView tvLowerMethod = new TextView(getContext());
            tvLowerMethod.setText(formatMethodName(result.getMethodName()) + ": " + result.getScore() + "%");
            tvLowerMethod.setPadding(4, 4, 4, 4);
            lowerScoredMethodsLayout.addView(tvLowerMethod);
        }

        btnRestart.setOnClickListener(v -> {
            // Navigate back to the quiz fragment to restart
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, new QuizFragment())
                    .commit();
        });

        btnMainMenu.setOnClickListener(v -> {
            // Navigate back to the main menu
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, new HomeFragment())
                    .commit();
        });

        return view;
    }

    private List<Result> sortResults(String results) {
        String[] lines = results.split("\n");
        List<Result> resultList = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(": ");
            if (parts.length == 2) {
                String methodName = parts[0];
                int score = Integer.parseInt(parts[1].replace("%", ""));
                resultList.add(new Result(methodName, score));
            }
        }

        Collections.sort(resultList, Comparator.comparingInt(Result::getScore).reversed());
        return resultList;
    }

    private int getImageResource(String methodName) {
        switch (methodName) {
            case "Living Labs":
                return R.drawable.living_labs_image;
            case "World Café":
                return R.drawable.wordcaf_image;
            case "Enquêteren":
                return R.drawable.enqueteren_image;
            case "Burgerjury":
                return R.drawable.burgerjury_image;
            case "Klankbord Groep":
                return R.drawable.klankbord_image;
            case "Inspraak Bijeenkomst":
                return R.drawable.inspraak_image;
            case "Straat Interviews":
                return R.drawable.straat_image;
            case "Scenariobouw":
                return R.drawable.scenariobouw_image;
            case "Interactieve Internet Omgeving":
                return R.drawable.interactieve_image;
            case "Keukentafel Gesprekken":
                return R.drawable.keukentafel_image;
            case "Photovoice":
                return R.drawable.photovoice_image;
            case "Swipocratie":
                return R.drawable.swipocratie_image;
            default:
                return 0; // Default image or handle no image case
        }
    }

    private int getBorderResource(String methodName) {
        switch (methodName) {
            case "Living Labs":
                return R.drawable.livinglabs_rounded_square;
            case "World Café":
                return R.drawable.wordcafe_rounded_square;
            case "Enquêteren":
                return R.drawable.enqueteren_rounded_square;
            case "Burgerjury":
                return R.drawable.burgerjury_rounded_square;
            case "Klankbord Groep":
                return R.drawable.klankbord_rounded_square;
            case "Inspraak Bijeenkomst":
                return R.drawable.inspraak_rounded_square;
            case "Straat Interviews":
                return R.drawable.straat_rounded_square;
            case "Scenariobouw":
                return R.drawable.scenariobouw_rounded_square;
            case "Interactieve Internet Omgeving":
                return R.drawable.interactieve_rounded_square;
            case "Keukentafel Gesprekken":
                return R.drawable.keukentafel_rounded_square;
            case "Photovoice":
                return R.drawable.photovoice_rounded_square;
            case "Swipocratie":
                return R.drawable.swipocratie_rounded_square;
            default:
                return R.drawable.border; // Default border or handle no border case
        }
    }

    private String formatMethodName(String methodName) {
        switch (methodName) {
            case "Klankbord Groep":
                return "Klankbordgroep";
            case "Inspraak Bijeenkomst":
                return "Inspraakbijeenkomst";
            case "Straat Interviews":
                return "Straatinterviews";
            case "Interactieve Internet Omgeving":
                return "Interactieve Internetomgeving";
            case "Keukentafel Gesprekken":
                return "Keukentafelgesprekken";
            default:
                return methodName;
        }
    }

    private static class Result {
        private final String methodName;
        private final int score;

        public Result(String methodName, int score) {
            this.methodName = methodName;
            this.score = score;
        }

        public String getMethodName() {
            return methodName;
        }

        public int getScore() {
            return score;
        }
    }
}
