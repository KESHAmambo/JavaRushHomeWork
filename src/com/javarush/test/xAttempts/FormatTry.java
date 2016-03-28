package com.javarush.test.xAttempts;

import java.text.*;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by ������� on 19.10.2015.
 */
public class FormatTry
{
    public static void main(String[] args)
    {
        MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0}.");
        double[] filelimits = {0,1,2};
        String[] filepart = {"no files","one file","{0} files"};
        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        form.setFormatByArgumentIndex(0, fileform);

        int fileCount = 3;
        String diskName = "MyDisk";
        Object[] testArgs = {2.99d, diskName};

        System.out.println(form.format(testArgs));

        int year = 1980;
        int month = 10;
        int day = 15;
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        int year1 = 1980;
        int month1 = 10;
        int day1 = 11;
        GregorianCalendar calendar1 = new GregorianCalendar(year1, month1, day1);
        Date date1 = calendar.getTime();
        Date date2 = calendar1.getTime();
        System.out.println(date1.equals(date2));
        System.out.println(date1.compareTo(date2));
        Double d1 = 10d;
        Double d2 = 1d;
        System.out.println(d1.compareTo(d2));
    }
}
