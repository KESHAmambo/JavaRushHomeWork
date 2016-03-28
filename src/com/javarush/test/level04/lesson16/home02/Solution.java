package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);
        a = max(a, b);
        c = min(a, c);
        System.out.println(c);//Напишите тут ваш код
    }

    public static int max(int a, int b)
    {
        if(a < b)
            return b;
        else
            return a;
    }

    public static int min(int a, int b)
    {
        if(a < b)
            return a;
        else
            return b;
    }
}
