package com.robert.model;

import java.util.ArrayList;

public class Accounts {
    ArrayList<Account> listOfAccounts = new ArrayList<>();

    public Accounts() {
        listOfAccounts.add(new Account("11111111-22222222", "HUF", 15000));
        listOfAccounts.add(new Account("22222222-33333333", "USD", 1230));
    }

    public ArrayList<Account> getListOfAccounts() {
        return listOfAccounts;
    }

}
