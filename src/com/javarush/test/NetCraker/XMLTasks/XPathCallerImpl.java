package com.javarush.test.NetCraker.XMLTasks;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Аркадий on 15.12.2015.
 */
public class XPathCallerImpl implements XPathCaller {

    @Override
    public Element[] getEmployees(Document src, String deptno, String docType) {
        try {
            src.getDocumentElement().normalize();
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = String.format("//employee[@deptno='%s']", deptno);
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(src, XPathConstants.NODESET);
            Element[] result = new Element[nodeList.getLength()];
            for(int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    result[i] = element;
                }
            }
            return result;
        } catch(Exception ignore) {}
        return new Element[0];
    }

    @Override
    public String getHighestPayed(Document src, String docType) {
        String resultName = null;
        try {
            src.getDocumentElement().normalize();
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//employee";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(src, XPathConstants.NODESET);
            double maxSalary = 0;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    double salary = Double.parseDouble(element.getElementsByTagName("sal").item(0).getTextContent());
                    if(salary > maxSalary) {
                        maxSalary = salary;
                        resultName = element.getElementsByTagName("ename").item(0).getTextContent();
                    }
                }
            }
        } catch(Exception ignore) {}
        return resultName;
    }

    @Override
    public String getHighestPayed(Document src, String deptno, String docType) {
        String resultName = null;
        try {
            src.getDocumentElement().normalize();
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = String.format("//employee[@deptno='%s']", deptno);
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(src, XPathConstants.NODESET);
            double maxSalary = 0;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    double salary = Double.parseDouble(element.getElementsByTagName("sal").item(0).getTextContent());
                    if(salary > maxSalary) {
                        maxSalary = salary;
                        resultName = element.getElementsByTagName("ename").item(0).getTextContent();
                    }
                }
            }
        } catch(Exception ignore) {}
        return resultName;
    }

    @Override
    public Element[] getTopManagement(Document src, String docType) {
        try {
            if(docType.equals("emp")) {
                src.getDocumentElement().normalize();
                XPath xPath = XPathFactory.newInstance().newXPath();
                String expression = "//employee";
                NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(src, XPathConstants.NODESET);
                ArrayList<Element> list = new ArrayList<>();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        if (element.getAttribute("mgr").equals("")) {
                            list.add(element);
                        }
                    }
                }
                Element[] result = new Element[list.size()];
                for (int i = 0; i < result.length; i++) {
                    result[i] = list.get(i);
                }
                return result;
            } else if(docType.equals("emp-hier")) {
                Element root = src.getDocumentElement();
                return new Element[]{root};
            }
        } catch(Exception ignore) {}
        return null;
    }

    @Override
    public Element[] getOrdinaryEmployees(Document src, String docType) {
        try {
            src.getDocumentElement().normalize();
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//employee";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(src, XPathConstants.NODESET);
            if(docType.equals("emp")) {
                ArrayList<Element> list = new ArrayList<>();
                Set<String> mgrIDList = new HashSet<>();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        list.add(element);
                        mgrIDList.add(element.getAttribute("mgr"));
                    }
                }
                Iterator<Element> it = list.iterator();
                while (it.hasNext()) {
                    if (mgrIDList.contains(it.next().getAttribute("empno"))) {
                        it.remove();
                    }
                }
                Element[] result = new Element[list.size()];
                for (int i = 0; i < result.length; i++) {
                    result[i] = list.get(i);
                }
                return result;
            } else if(docType.equals("emp-hier")) {
                ArrayList<Element> list = new ArrayList<>();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        if (element.getElementsByTagName("employee").getLength() == 0) {
                            list.add(element);
                        }
                    }
                }
                Element[] result = new Element[list.size()];
                for (int i = 0; i < result.length; i++) {
                    result[i] = list.get(i);
                }
                return result;
            }
        } catch(Exception ignore) {}
        return null;
    }

    @Override
    public Element[] getCoworkers(Document src, String empno, String docType) {
        try {
            src.getDocumentElement().normalize();
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//employee";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(src, XPathConstants.NODESET);
            if(docType.equals("emp")) {
                ArrayList<Element> list = new ArrayList<>();
                Element employee = null;
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        if (element.getAttribute("empno").equals(empno)) {
                            employee = element;
                            break;
                        }
                    }
                }
                for(int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        if (element.getAttribute("mgr").equals(employee.getAttribute("mgr"))
                                && !element.getAttribute("empno").equals(empno)) {
                            list.add(element);
                        }
                    }
                }
                Element[] result = new Element[list.size()];
                for (int i = 0; i < result.length; i++) {
                    result[i] = list.get(i);
                }
                return result;
            } else if(docType.equals("emp-hier")) {
                ArrayList<Element> list = new ArrayList<>();
                Node employee = null;
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        if (element.getAttribute("empno").equals(empno)) {
                            employee = element;
                            break;
                        }
                    }
                }
                NodeList cowList = employee.getParentNode().getChildNodes();
                for(int i = 0; i < cowList.getLength(); i++) {
                    Node node = cowList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        if(!element.getAttribute("empno").equals("") && !element.getAttribute("empno").equals(empno)) {
                            list.add(element);
                        }
                    }
                }
                Element[] result = new Element[list.size()];
                for (int i = 0; i < result.length; i++) {
                    result[i] = list.get(i);
                }
                return result;
            }
        } catch(Exception ignore) {
            ignore.printStackTrace();
        }
        return null;
    }
}
