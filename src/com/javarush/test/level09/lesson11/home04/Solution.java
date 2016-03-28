package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception
    {
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        Date date = new Date(reader.readLine());
        System.out.println(dateFormat.format(date).toUpperCase());*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));// better decision, because input format is entered unacceptable sometimes
        SimpleDateFormat outFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        SimpleDateFormat inFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);// for example of unacceptable format: MM/-dd/+++yyyy
        String stringDate = reader.readLine();
        Date date = inFormat.parse(stringDate);
        System.out.println(date);
        System.out.println(outFormat.format(date).toUpperCase());
    }
}
