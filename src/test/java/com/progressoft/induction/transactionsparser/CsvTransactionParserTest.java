package com.progressoft.induction.transactionsparser;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvTransactionParserTest {

    CsvTransactionParser temp;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        temp = new CsvTransactionParser();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        temp = null;
    }

    @org.junit.jupiter.api.Test
    void parseValid() {
        List<Transaction> list = temp.parse(new File("D:\\ProgressSoft\\transactions-parser-master\\src\\main\\resources\\transactions.csv"));

        ArrayList<Transaction> arr = new ArrayList<>();

        Transaction t = new Transaction();
        t.setDescription("Cash withdrawal");
        t.setDirection("Debit");
        t.setAmount(new BigDecimal("150"));
        t.setCurrency("JOD");
        arr.add(t);

        t = new Transaction();
        t.setDescription("Salary");
        t.setDirection("Credit");
        t.setAmount(new BigDecimal("1000"));
        t.setCurrency("USD");
        arr.add(t);

        t = new Transaction();
        t.setDescription("Bill Payment");
        t.setDirection("Debit");
        t.setAmount(new BigDecimal("20"));
        t.setCurrency("JOD");
        arr.add(t);

        assertEquals(arr, list);
    }
}