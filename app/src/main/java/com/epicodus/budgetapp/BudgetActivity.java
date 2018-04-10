package com.epicodus.budgetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.budgetapp.models.Budget;
import com.epicodus.budgetapp.models.Transaction;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BudgetActivity extends AppCompatActivity {
    @BindView(R.id.bAddDeposit) Button bAddDepositLabel;
    @BindView(R.id.etStartBalDeposit) EditText etStartBalDepositLabel;

    private Budget budget;
    private ArrayList<Transaction> transactions = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        ButterKnife.bind(this);

        bAddDepositLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                budget = new Budget(0,0,0, transactions, "");
//                String Start = mLocationEditText.getText().toString();


            }
        });

    }

}
