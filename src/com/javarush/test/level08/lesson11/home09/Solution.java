package com.javarush.test.level08.lesson11.home09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException
    {

    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        Date currentDate = new SimpleDateFormat("MMMM d yy", Locale.ENGLISH).parse(date);
        Date yearBegin = new SimpleDateFormat("MMMM d yy", Locale.ENGLISH).parse(date);
        yearBegin.setMonth(0);
        yearBegin.setDate(0);
        long msDelay = currentDate.getTime() - yearBegin.getTime();
        long msInDay = 24 * 60 * 60 * 1000;
        if((int) (msDelay / msInDay) % 2 != 0)
            return true;
        else
            return false;
    }
}
