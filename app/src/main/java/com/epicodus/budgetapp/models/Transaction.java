package com.epicodus.budgetapp.models;

public class Transaction {
    private String date;
    private String note;
    private Integer amount;
    private String debitOrCredit;
    private String transType;
    private String cleared;
    private Integer id;

    public Transaction(String date, String note, Integer amount, String debitOrCredit, String transType, String cleared) {
        this.date = date;
        this.note = note;
        this.amount = amount;
        this.debitOrCredit = debitOrCredit;
        this.transType = transType;
        this.cleared = cleared;
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

    public String getCleared() {
        return cleared;
    }

    public void setCleared(String cleared) {
        this.cleared = cleared;
    }
}
