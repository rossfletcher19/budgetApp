package com.epicodus.budgetapp.models;

import java.util.ArrayList;

public class Budget {
    private Integer net_income;
    private Integer after_mandatory_exp;
    private Integer running_bal;
    private ArrayList<Transaction> transactions;
    private String month;
    private Integer id;

    public Budget(Integer net_income, Integer after_mandatory_exp, Integer running_bal, ArrayList<Transaction> transactions, String month) {
        this.net_income = net_income;
        this.after_mandatory_exp = after_mandatory_exp;
        this.running_bal = running_bal;
        this.transactions = transactions;
        this.month = month;
    }

    public Integer getNet_income() {
        return net_income;
    }

    public void setNet_income(Integer net_income) {
        this.net_income = net_income;
    }

    public Integer getAfter_mandatory_exp() {
        return after_mandatory_exp;
    }

    public void setAfter_mandatory_exp(Integer after_mandatory_exp) {
        this.after_mandatory_exp = after_mandatory_exp;
    }

    public Integer getRunning_bal() {
        return running_bal;
    }

    public void setRunning_bal(Integer running_bal) {
        this.running_bal = running_bal;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
