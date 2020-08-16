package com.robert.model;

import java.io.Serializable;

public class Transaction implements Serializable {
    private String accountNumber;
    private String currency;
    private double amount;
    private double rate;
    private double newBalanceOfAcc;

    public Transaction(String accountNumber, String currency, double amount, double rate) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.amount = amount;
        this.rate = rate;
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

    @Override
    public String toString() {
        return "Tranzakciós üzenet:{" +
                "Számlaszám: " + accountNumber +
                ", Pénznem: " + currency +
                ", Összeg: " + amount +
                ", Valutaárfolyam: " + rate +
                '}';
    }
}
