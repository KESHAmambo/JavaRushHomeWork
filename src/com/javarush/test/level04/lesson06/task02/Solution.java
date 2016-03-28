package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        int a = Integer.parseInt(s1);
        String s2 = reader.readLine();
        int b = Integer.parseInt(s2);
        String s3 = reader.readLine();
        int c = Integer.parseInt(s3);
        String s4 = reader.readLine();
        int d = Integer.parseInt(s4);

        a = max(a, b);
        c = max(c, d);
        System.out.println(max(a, c));
    }

    public static int max(int a, int b)
    {
        if(a > b)
            return a;
        else
            return b;
    }
}
