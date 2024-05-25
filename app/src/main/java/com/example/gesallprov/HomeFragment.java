package com.example.gesallprov;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    // Gebruikt als knop en welkomstbericht
    private TextView findWorkform;
    // Declareer view
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Initialiseer view en inflate de layout voor dit fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialiseer welkomsttekst, te vinden in de layout
        findWorkform = view.findViewById(R.id.tvWelcomeHeader);

        // Stel een click listener in voor de knop, vervang het fragment bij klikken
        findWorkform.setOnClickListener(new View.OnClickListener() {
            // De onderstaande code werkt om naar de quizpagina te gaan,
            // maar de icoon laat nog steeds zien dat je op "Home" bent, ook al ben je op Quiz...
            @Override
            public void onClick(View v) {
                replaceFragment(new QuizFragment());
            }
        });
        // Return view
        return view;
    }

    // Methode om het fragment te vervangen
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment); // Vervang het huidige fragment
        fragmentTransaction.commit(); // Bevestig de transactie
    }
}
