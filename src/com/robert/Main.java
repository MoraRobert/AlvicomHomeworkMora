package com.robert;

import com.robert.model.Accounts;
import com.robert.model.Transaction;
import com.robert.operations.OperateOnAccounts;
import com.robert.operations.ReadToinMemoryDBimpl;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ReadToinMemoryDBimpl Acomplish = new ReadToinMemoryDBimpl();
        ArrayList<Transaction> transactions = Acomplish.readIn();

        Accounts accounts = new Accounts();

        OperateOnAccounts operate = new OperateOnAccounts();
        operate.changeBalance(accounts, transactions);
    }
}
