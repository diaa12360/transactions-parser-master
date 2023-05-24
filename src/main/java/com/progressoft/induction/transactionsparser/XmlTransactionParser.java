package com.progressoft.induction.transactionsparser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XmlTransactionParser implements TransactionParser {
    @Override
    public List<Transaction> parse(File transactionsFile) {
        List<Transaction> list = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(transactionsFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Transaction");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Transaction t = new Transaction();
                    Element eElement = (Element) node;
                    t.setDescription(eElement.getElementsByTagName("Description").item(0).getTextContent());
                    t.setDirection(eElement.getElementsByTagName("Direction").item(0).getTextContent());
                    Element e = (Element) eElement.getElementsByTagName("Amount").item(0);
                    t.setAmount(new BigDecimal(e.getElementsByTagName("Value").item(0).getTextContent()));
                    t.setCurrency(e.getElementsByTagName("Currency").item(0).getTextContent());
                    list.add(t);
                }
            }
        }
        catch (ParserConfigurationException | SAXException | IOException e){
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }
}
