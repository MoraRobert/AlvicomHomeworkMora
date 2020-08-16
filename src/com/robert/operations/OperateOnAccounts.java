package com.robert.operations;

import com.robert.model.Account;
import com.robert.model.Accounts;
import com.robert.model.Transaction;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OperateOnAccounts {


    public void changeBalance(Accounts accounts, ArrayList<Transaction> transactions){
        int count = 1;

        for (Transaction trs : transactions) {
            for (Account acc : accounts.getListOfAccounts()) {
                if(trs.getAccountNumber().equalsIgnoreCase(acc.getAccountNumber())){
                    if (!trs.getCurrency().equalsIgnoreCase(acc.getCurrency())){
                        trs.setAmount( (trs.getAmount() * trs.getRate()) );
                    }
                    if (trs.getAmount() < 0 && acc.getBalance() < Math.abs(trs.getAmount())){
                        System.out.println("A " + count + ". tranzakció nem hajtható végre, nincs rá fedezet.");
                        trs.setNewBalanceOfAcc(acc.getBalance());
                        System.out.println();
                    } else {
                        acc.setBalance(acc.getBalance() + trs.getAmount());
                        trs.setNewBalanceOfAcc(acc.getBalance());
                        count++;
                    }
                    break;
                }
            }

            if (count % 10 == 0 && count !=0) {
                printToConsole(accounts, transactions, count);
            }
        }
    }

    public void printToConsole(Accounts accounts, ArrayList<Transaction> transactions, int i){
        DecimalFormat df = new DecimalFormat("###,###,###.##");
        for (Account acc: accounts.getListOfAccounts()) {
            System.out.println("A " + acc.getAccountNumber() + " számú számlán végrehajtott műveletek: ");
            for (int j = 0; j < i; j++) {
                if (transactions.get(j).getAccountNumber().equals(acc.getAccountNumber())){
                    System.out.println("Egyenleg változás: "
                            + df.format(transactions.get(j).getAmount() )
                            + "     Új egyenleg: " + df.format(transactions.get(j).getNewBalanceOfAcc()));
                }
            }
            System.out.println();
        }
    }
}
