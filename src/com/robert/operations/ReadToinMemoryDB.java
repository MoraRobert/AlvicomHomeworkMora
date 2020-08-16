package com.robert.operations;

import com.robert.model.Transaction;

import java.util.ArrayList;

public interface ReadToinMemoryDB {

    ArrayList<Transaction> readIn();
}
