package com.example.gesallprov;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        TextView tvResults = view.findViewById(R.id.tvResults);
        Button btnRestart = view.findViewById(R.id.btnRestart);
        Button btnMainMenu = view.findViewById(R.id.btnMainMenu);

        // Sort results
        String sortedResults = sortResults(results);

        tvResults.setText(sortedResults);

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

    private String sortResults(String results) {
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

        StringBuilder sortedResults = new StringBuilder();
        for (Result result : resultList) {
            sortedResults.append(result.getMethodName()).append(": ").append(result.getScore()).append("%\n");
        }

        return sortedResults.toString().trim();
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
