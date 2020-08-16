package com.robert.operations;

import com.robert.model.Account;
import com.robert.model.Accounts;
import com.robert.model.Transaction;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OperateOnAccounts {


    public void changeBalance(Accounts accounts, ArrayList<Transaction> transactions){
        int count = 1;
        double amountToDeposit;
        for (Transaction trs : transactions) {
            for (Account acc : accounts.getListOfAccounts()) {
                if(trs.getAccountNumber().equalsIgnoreCase(acc.getAccountNumber())){
                    if (!trs.getCurrency().equalsIgnoreCase(acc.getCurrency())){
                        amountToDeposit = trs.getAmount() * trs.getRate();
                    } else amountToDeposit = trs.getAmount();
                    if (amountToDeposit < 0 && acc.getBalance() < Math.abs(amountToDeposit)){
                        trs.setFlag(false);
                        trs.setNewBalanceOfAcc(acc.getBalance());
                        System.out.println();
                    } else {
                        acc.setBalance(acc.getBalance() + amountToDeposit);
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
        String detail = "";
        for (Account acc: accounts.getListOfAccounts()) {
            System.out.println("A " + acc.getAccountNumber() + " számú számlán végrehajtott műveletek: ");
            for (int j = 0; j < i; j++) {
                if (transactions.get(j).getAccountNumber().equals(acc.getAccountNumber())){
                    if (transactions.get(j).isFlag()) detail = "";
                    else detail = "    A tranzakció nem hajtható végre, nincs rá fedezet.";
                    System.out.println(df.format(transactions.get(j).getAmount()) + " " + transactions.get(j).getCurrency() +
                            "       Egyenleg változás: "
                            + df.format(transactions.get(j).getAmount() * transactions.get(j).getRate()) + " " + acc.getCurrency()
                            + "     Új egyenleg: " + df.format(transactions.get(j).getNewBalanceOfAcc()) + " " + acc.getCurrency()
                            + detail);
                }
            }
            System.out.println();
        }
    }
}
