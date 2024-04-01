package com.example.gesallprov;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    // appens logga, används både som knapp och logga. knapp för att roteras vid ett knapptryck
    private TextView findWorkform;
    // deklarerar view
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // initialiserar view och inflate layouten för det här fragmentet
        view = inflater.inflate(R.layout.fragment_home, container, false);

        // initialiserar welcome text, hittar i layouten
        findWorkform = view.findViewById(R.id.tvWelcomeHeader);

        // sätter en knapp-lyssnare på knappen, roterar vid knapptryck
        findWorkform.setOnClickListener(new View.OnClickListener() {
           // nedanstående kod funkar med att gå till quiz sidan men ikonen visar fortfarande
            // att man är på "Home" även fast man ör på Quiz...
            @Override
            public void onClick(View v) {
                replaceFragment(new QuizFragment());
            }
        });
        // returnerar view
        return view;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

    }

}