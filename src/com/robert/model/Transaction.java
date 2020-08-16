package com.robert.model;

import java.io.Serializable;

public class Transaction implements Serializable {
    private String accountNumber;
    private String currency;
    private double amount;
    private double rate;
    private double newBalanceOfAcc;
    private boolean flag;

    public Transaction(String accountNumber, String currency, double amount, double rate) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.amount = amount;
        this.rate = rate;
        this.flag = true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public double getNewBalanceOfAcc() {
        return newBalanceOfAcc;
    }

    public void setNewBalanceOfAcc(double newBalanceOfAcc) {
        this.newBalanceOfAcc = newBalanceOfAcc;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
