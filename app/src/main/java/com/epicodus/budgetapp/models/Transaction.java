package com.epicodus.budgetapp.models;

public class Transaction {
    private String date;
    private String note;
    private Integer amount;
    private String debitOrCredit;
    private String transType;
    private Integer id;

    public Transaction(String date, String debitOrCredit, String note, Integer amount, String transType) {
        this.date = date;
        this.debitOrCredit = debitOrCredit;
        this.note = note;
        this.amount = amount;
        this.transType = transType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDebitOrCredit() {
        return debitOrCredit;
    }

    public void setDebitOrCredit(String debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }
}
