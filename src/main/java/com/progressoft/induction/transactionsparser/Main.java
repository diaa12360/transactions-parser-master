package com.progressoft.induction.transactionsparser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TransactionParser tp = new XmlTransactionParser();
        List<Transaction> list = tp.parse(new File("D:\\ProgressSoft\\transactions-parser-master\\src\\main\\resources\\transactions.xml"));
        System.out.println(list);
        tp = new CsvTransactionParser();
        list = tp.parse(new File("D:\\ProgressSoft\\transactions-parser-master\\src\\main\\resources\\transactions.csv"));
        System.out.println(list);
    }
}
