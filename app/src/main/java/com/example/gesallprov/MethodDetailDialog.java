package com.example.gesallprov;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MethodDetailDialog extends DialogFragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";

    private String title;
    private String description;

    public static MethodDetailDialog newInstance(String title, String description) {
        MethodDetailDialog fragment = new MethodDetailDialog();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            description = getArguments().getString(ARG_DESCRIPTION);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_method_detail_dialog, container, false);

        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvDescription = view.findViewById(R.id.tvDescription);
        Button btnClose = view.findViewById(R.id.btnClose);

        // Modify the title to present as one word if it matches any specific method names
        title = formatMethodName(title);

        tvTitle.setText(title);
        tvDescription.setText(description);

        btnClose.setOnClickListener(v -> dismiss());

        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle(title);
        return dialog;
    }

    private String formatMethodName(String methodName) {
        switch (methodName) {
            case "Klankbord groep":
                return "Klankbordgroep";
            case "Inspraak bijeenkomst":
                return "Inspraakbijeenkomst";
            case "Straat interviews":
                return "Straatinterviews";
            case "Interactieve Internet omgeving":
                return "Interactieve Internetomgeving";
            case "Keukentafel gesprekken":
                return "Keukentafelgesprekken";
            case "Scenario- bouw":
                return "Scenariobouw";
            default:
                return methodName;
        }
    }
}
