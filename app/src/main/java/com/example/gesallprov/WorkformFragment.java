package com.example.gesallprov;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WorkformFragment extends Fragment {

    public WorkformFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workform, container, false);

        setupMethodDetails(view, R.id.living_labs_constraint, R.string.living_labs, R.string.living_labs_description);
        setupMethodDetails(view, R.id.second_living_labs_constraint, R.string.wordcaf, R.string.wordcaf_description);
        setupMethodDetails(view, R.id.enqueteren_constraint, R.string.enqu_teren, R.string.enqu_teren_description);
        setupMethodDetails(view, R.id.burgerjury_constraint, R.string.burgerjury, R.string.burgerjury_description);
        setupMethodDetails(view, R.id.klankbord_constraint, R.string.klankbord_groep, R.string.klankbord_groep_description);
        setupMethodDetails(view, R.id.inspraak_constraint, R.string.inspraak_bijeenkomst, R.string.inspraak_bijeenkomst_description);
        setupMethodDetails(view, R.id.straat_constraint, R.string.straat_interviews, R.string.straat_interviews_description);
        setupMethodDetails(view, R.id.swipocratie_constraint, R.string.swipocratie, R.string.swipocratie_description);
        setupMethodDetails(view, R.id.interactieve_constraint, R.string.interactieve_internet_omgeving, R.string.interactieve_internet_omgeving_description);
        setupMethodDetails(view, R.id.scenariobouw_constraint, R.string.interactieve_scenariobouw, R.string.interactieve_scenariobouw_description);
        setupMethodDetails(view, R.id.keukentafel_constraint, R.string.keukentafel_gesprekken, R.string.keukentafel_gesprekken_description);
        setupMethodDetails(view, R.id.photovoice_constraint, R.string.photovoice, R.string.photovoice_description);

        return view;
    }

    private void setupMethodDetails(View view, int constraintId, int titleId, int descriptionId) {
        View methodView = view.findViewById(constraintId);
        methodView.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            MethodDetailDialog.newInstance(getString(titleId), getString(descriptionId))
                    .show(fragmentManager, "method_detail");
        });
    }
}
