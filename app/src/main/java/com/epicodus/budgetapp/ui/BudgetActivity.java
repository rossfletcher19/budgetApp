package com.epicodus.budgetapp.ui;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v4.app.DialogFragment;


import com.epicodus.budgetapp.R;
import com.epicodus.budgetapp.models.Budget;
import com.epicodus.budgetapp.models.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BudgetActivity extends AppCompatActivity {
    @BindView(R.id.tvNetIncomeOutput) TextView tvNetIncomeOutputLabel;
    @BindView(R.id.tvAfterMandOutput) TextView tvAfterMandOutputLabel;
    @BindView(R.id.tvRunninBalOutput) TextView tvRunninBalOutputLabel;
    @BindView(R.id.rvTransHistory) RecyclerView rvTransHistoryLabel;
    @BindView(R.id.etTransDate) EditText etTransDateLabel;
    @BindView(R.id.etTransAmt) EditText etTransAmtLabel;
    @BindView(R.id.etTransNote) TextView etTransNoteLabel;
    @BindView(R.id.spTransType) Spinner spTransTypeLabel;
    @BindView(R.id.bTransSubmitButton) Button bTransSubmitButtonLabel;
    @BindView(R.id.rgDebitCredit) RadioGroup rgDebitCreditLabel;



    private Budget budget;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private String transDate;
    Calendar myCalendar = Calendar.getInstance();
    String[] transactionCategories = {"deposit","mortgage", "groceries", "gas", "utilities", "misc.", "phone", "loan", "insurance", "credit card", "medical", "entertainment"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        ButterKnife.bind(this);
        budget = new Budget(0,0,0, transactions, "");
        EditText dateEditText = (EditText) findViewById(R.id.etTransDate);
        ArrayAdapter<String> transTypeAdapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, transactionCategories);

        Spinner spinner = (Spinner) findViewById(R.id.spTransType);
        ArrayAdapter<String> transTypeArrayAdapterSp = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        transactionCategories);
        transTypeArrayAdapterSp.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner.setAdapter(transTypeArrayAdapterSp);


        tvNetIncomeOutputLabel.setText(String.format("%s", budget.getNet_income()));
        tvAfterMandOutputLabel.setText(String.format("%s", budget.getAfter_mandatory_exp()));
        tvRunninBalOutputLabel.setText(String.format("%s", budget.getRunning_bal()));

        bTransSubmitButtonLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String transNote = etTransNoteLabel.getText().toString();
                Integer transAmount = Integer.parseInt(etTransAmtLabel.getText().toString());
                int selectedId = rgDebitCreditLabel.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String rDebitOrCreditSelection = radioButton.getText().toString();
                String transDate = etTransDateLabel.getText().toString();


                Transaction transaction = new Transaction(transDate,transNote,transAmount,rDebitOrCreditSelection,"","");
                System.out.println(transaction.getAmount());




            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        dateEditText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(BudgetActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        etTransNoteLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                NoteDialogFragment noteDialogFragment = new NoteDialogFragment();
                noteDialogFragment.show(fm, "note dialog");
            }
        });

    }

//    public String setTransDate(){
//
//        cal.add(Calendar.DATE, 1);
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//        String formattedDate = format1.format(cal.getTime());
//        System.out.println(formattedDate);
//        return formattedDate;
//
//    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        etTransDateLabel.setText(sdf.format(myCalendar.getTime()));




    }

}
