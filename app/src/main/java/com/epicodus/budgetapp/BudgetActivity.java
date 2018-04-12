package com.epicodus.budgetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.epicodus.budgetapp.models.Budget;
import com.epicodus.budgetapp.models.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
    @BindView(R.id.etTransNote) EditText etTransNoteLabel;
    @BindView(R.id.etTransType) EditText etTransTypeLabel;
    @BindView(R.id.bTransSubmitButton) Button bTransSubmitButtonLabel;
    @BindView(R.id.rgDebitCredit) RadioGroup rgDebitCreditLabel;



    private Budget budget;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private String transDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        ButterKnife.bind(this);
        budget = new Budget(0,0,0, transactions, "");


        tvNetIncomeOutputLabel.setText(String.format("%s", budget.getNet_income()));
        tvAfterMandOutputLabel.setText(String.format("%s", budget.getAfter_mandatory_exp()));
        tvRunninBalOutputLabel.setText(String.format("%s", budget.getRunning_bal()));





        bTransSubmitButtonLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transaction transaction = new Transaction("","",0,"","","");
                transaction.setDate(setTransDate());
                String transNote = etTransNoteLabel.getText().toString();
                Integer transAmount = Integer.parseInt(etTransAmtLabel.getText().toString());
                int selectedId = rgDebitCreditLabel.getCheckedRadioButtonId();



            }
        });

    }

    public String setTransDate(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = format1.format(cal.getTime());
        System.out.println(formattedDate);
        return formattedDate;

    }

}
