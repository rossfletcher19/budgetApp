package com.epicodus.budgetapp.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import android.icu.util.EthiopicCalendar;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.epicodus.budgetapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteDialogFragment extends DialogFragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_note_dialog, container, false);

        Button submitButton = (Button) rootView.findViewById(R.id.buttobSubmitTransNotesn2);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText transNotesEt = (EditText) rootView.findViewById(R.id.etTransNote);
                String transNotes = transNotesEt.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("transNotes", transNotes);
                Intent intent = getActivity().getIntent();
                intent.putExtras(bundle);
                dismiss();
            }
        });

        return rootView;
    }


}
