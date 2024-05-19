package com.example.gesallprov;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

        tvResults.setText(results);

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
}
