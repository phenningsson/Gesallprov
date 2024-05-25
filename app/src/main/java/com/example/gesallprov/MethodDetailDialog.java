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

    // Constante voor het opslaan van titel en beschrijving
    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";

    // Variabelen voor titel en beschrijving
    private String title;
    private String description;

    // Methode om een nieuw instance van MethodDetailDialog te maken met titel en beschrijving
    public static MethodDetailDialog newInstance(String title, String description) {
        MethodDetailDialog fragment = new MethodDetailDialog();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    // Methode die wordt aangeroepen bij de creatie van de fragment
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE); // Haalt de titel op uit de argumenten
            description = getArguments().getString(ARG_DESCRIPTION); // Haalt de beschrijving op uit de argumenten
        }
    }

    // Methode die de view voor het fragment creëert
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflates de layout voor dit fragment
        View view = inflater.inflate(R.layout.fragment_method_detail_dialog, container, false);

        // Initialiseer de TextView en Button
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvDescription = view.findViewById(R.id.tvDescription);
        Button btnClose = view.findViewById(R.id.btnClose);

        // Wijzig de titel zodat deze als één woord wordt weergegeven indien nodig
        title = formatMethodName(title);

        // Stel de tekst in voor titel en beschrijving
        tvTitle.setText(title);
        tvDescription.setText(description);

        // Sluit de dialoog bij het klikken op de sluitknop
        btnClose.setOnClickListener(v -> dismiss());

        return view;
    }

    // Methode die de dialoog creëert en de titel instelt
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle(title); // Stelt de titel in voor de dialoog
        return dialog;
    }

    // Methode die de naam van de methoden formatteert zodat ze als één woord worden weergegeven
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
                return methodName; // Als geen van de bovenstaande, retourneer de oorspronkelijke naam
        }
    }
}
