package com.javarush.test.NetCraker.XMLTasks;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import sun.plugin.dom.core.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Аркадий on 15.12.2015.
 */
public class MainXPathCaller {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File("c:/javaidea/xml/emp.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = dBuilder.parse(inputFile);
        XPathCaller caller = new XPathCallerImpl();
        Element[] array = caller.getEmployees(doc, "30", "emp");
        for(Element element: array) {
            System.out.println("Employee name: "
                    + element.getElementsByTagName("ename").item(0).getTextContent());
        }
        System.out.println("HighestPayed: " + caller.getHighestPayed(doc, "emp-hier"));
        System.out.println("HighestPayed in department: " + caller.getHighestPayed(doc, "20", "emp-hier"));
        array = caller.getTopManagement(doc, "emp");
        for(Element element: array) {
            System.out.println("TopManager name: "
                    + element.getElementsByTagName("ename").item(0).getTextContent());
        }
        array = caller.getOrdinaryEmployees(doc, "emp-hier");
        for(Element element: array) {
            System.out.println("NotManager name: "
                    + element.getElementsByTagName("ename").item(0).getTextContent());
        }
        array = caller.getCoworkers(doc,"7839", "emp");
        for(Element element: array) {
            System.out.println("Coworker's name: "
                    + element.getElementsByTagName("ename").item(0).getTextContent());
        }
    }
}
