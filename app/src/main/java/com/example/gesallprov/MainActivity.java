package com.example.gesallprov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.example.gesallprov.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Maak een instantie van ActivityMainBinding
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Maak een instantie van ActivityMainBinding en haal de XML-layout op
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Stel de inhoud van de activiteit in op de root-view van de binding
        setContentView(binding.getRoot());

        // Vervang het huidige fragment door het HomeFragment bij het opstarten van de app
        replaceFragment(new HomeFragment());

        // Luister naar klikken op de navigatiebalk onderaan (bottomNavigationView),
        // die is gemaakt in de map "menu" met resource-bestanden
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            // Vervang het fragment afhankelijk van welke knop in de navigatiebalk is aangeklikt
            switch (item.getItemId()){

                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.workform:
                    replaceFragment(new WorkformFragment());
                    break;
                case R.id.quiz:
                    replaceFragment(new QuizFragment());
                    break;
                case R.id.about:
                    replaceFragment(new AboutFragment());
                    break;
            }
            return true; // Geef aan dat het item is geselecteerd
        });
    }

    // Methode om het fragment op de root-view van de activiteit te vervangen
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment); // Vervang het huidige fragment
        fragmentTransaction.commit(); // Bevestig de transactie
    }
}
