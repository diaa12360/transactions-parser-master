package com.progressoft.induction.transactionsparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class CsvTransactionParser implements TransactionParser{

    @Override
    public List<Transaction> parse(File transactionsFile) {
        List<Transaction> list = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(transactionsFile));
            String line = "";
            while ((line = in.readLine()) != null){
                String[] arr = line.split(",");
                Transaction t = new Transaction();
                t.setDescription(arr[0]);
                t.setDirection(arr[1]);
                t.setAmount(new BigDecimal(arr[2]));
                t.setCurrency(arr[3]);
                list.add(t);
            }
            in.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }
}
