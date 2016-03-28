package com.javarush.test.NetCraker.JavaAPI.Business_Card;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Аркадий on 06.12.2015.
 */
public class MainBC
{
    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner("Chuck;Norris;DSI;14-12-1940;M;1000;1234567890");
        BusinessCard bc = new BusinessCardImpl();
        bc = bc.getBusinessCard(scan);
        System.out.println("Employee: " + bc.getEmployee());
        System.out.println("Department: " + bc.getDepartment());
        System.out.println("Salary: " + bc.getSalary());
        System.out.println("Age: " + bc.getAge());
        System.out.println("Gender: " + bc.getGender());
        System.out.println("Phone: " + bc.getPhoneNumber());
    }
}
