package com.javarush.test.NetCraker.JavaAPI.Business_Card;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Аркадий on 06.12.2015.
 */

public class BusinessCardImpl implements BusinessCard
{
    private String name;
    private String lastName;
    private String department;
    private String birthDate;
    private String phoneNumber;
    private Character gender;
    private Integer salary;

    @Override
    public BusinessCard getBusinessCard(Scanner scanner)
            throws NoSuchElementException
    {
        String input = scanner.nextLine();
        String[] array = input.split(";");
        if(array.length != 7) {
            throw new NoSuchElementException();
        }
        name = array[0];
        lastName = array[1];
        department = array[2];

        Pattern datePat = Pattern.compile("[0-9]{2}-[0-9]{2}-[0-9]{4}");
        Matcher dateMatcher = datePat.matcher(array[3]);
        if(!dateMatcher.matches()) {
            throw new InputMismatchException();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(array[3]);
        }
        catch (ParseException e) {
            throw new InputMismatchException();
        }
        birthDate = array[3];

        Pattern genPat = Pattern.compile("[MF]");
        Matcher genMatcher = genPat.matcher(array[4]);
        if(!genMatcher.matches()) {
            throw new InputMismatchException();
        }
        gender = array[4].charAt(0);

        try {
            salary = Integer.parseInt(array[5]);
            if(salary < 100 || salary > 100000) {
                throw new InputMismatchException();
            }
        } catch(NumberFormatException e) {
            throw new InputMismatchException();
        }

        Pattern phonePat = Pattern.compile("[0-9]{10}");
        Matcher phoneMatcher = phonePat.matcher(array[6]);
        if(!phoneMatcher.matches()) {
            throw new InputMismatchException();
        }
        phoneNumber = array[6];

        return this;
    }

    @Override
    public String getEmployee()
    {
        return name + " " + lastName;
    }

    @Override
    public String getDepartment()
    {
        return department;
    }

    @Override
    public int getSalary()
    {
        return salary;
    }

    @Override
    public int getAge()
    {
        int result = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date birth = sdf.parse(birthDate);
            Date current = new Date();
            long diff = current.getTime() - birth.getTime();
            result = (int) (diff / ((long)1000 * 60 * 60 * 24 * 365));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getGender()
    {
        if(gender.equals('M'))
            return "Male";
        else if(gender.equals('F'))
            return "Female";
        else
            return "Invalid gender.";
    }

    @Override
    public String getPhoneNumber()
    {
        StringBuilder result = new StringBuilder("+7 ");;
        result.append(phoneNumber.substring(0, 3));
        result.append('-');
        result.append(phoneNumber.substring(3, 6));
        result.append('-');
        result.append(phoneNumber.substring(6, 8));
        result.append('-');
        result.append(phoneNumber.substring(8));
        return result.toString();
    }
}
