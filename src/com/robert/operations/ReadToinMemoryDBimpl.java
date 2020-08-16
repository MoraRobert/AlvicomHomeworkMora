package com.robert.operations;

import com.robert.model.Accounts;
import com.robert.model.Transaction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadToinMemoryDBimpl implements ReadToinMemoryDB{

    public ArrayList<Transaction> readIn(){
        String csvFile = "C:/Spring/AlvicomHomework_Mora/transactions.csv"; //az úvonalat a megfelelő útvonalra szükséges beállítani
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Transaction> transactions = new ArrayList<>();  //a beérkező üzenetek inmemory tárhelye
        Accounts accounts = new Accounts();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            int count = 1;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(cvsSplitBy);

                if (lines[0].equals(accounts.getListOfAccounts().get(0).getAccountNumber()) ||
                        lines[0].equals(accounts.getListOfAccounts().get(1).getAccountNumber())) {
                    if (lines[3].equalsIgnoreCase(" null")){
                        Transaction trs = new Transaction(lines[0], lines[1], Double.parseDouble(lines[2]), 1);
                        transactions.add(trs);
                        count++;
                    } else {
                       Transaction trs = new Transaction(lines[0], lines[1], Double.parseDouble(lines[2]), Double.parseDouble(lines[3]));
                       transactions.add(trs);
                        count++;
                    }

                } else {
                    System.out.println();
                    System.out.println("figyelmeztetés: a " + count  + ". tranzakció nem létező számlára vonatkozik");
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return transactions;
    }

}
