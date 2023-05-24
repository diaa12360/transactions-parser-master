package com.progressoft.induction.transactionsparser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface TransactionParser {

    List<Transaction> parse(File transactionsFile);
}
