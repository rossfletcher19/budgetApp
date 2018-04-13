package com.epicodus.budgetapp.ui;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.epicodus.budgetapp.R;

public class NoteDialogFragment extends DialogFragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_note_dialog, container, false);
        return rootView;
    }
}
