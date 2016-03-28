package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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

        int val4 = max(max(a, b), max(a, c));
        System.out.println(val4);
        if (val4 == a)
        {
            System.out.println(max(b, c));
            System.out.println(min(b, c));
        }
        else if (val4 == b)
        {
            System.out.println(max(a, c));
            System.out.println(min(a, c));
        }
        else if (val4 == c)
        {
            System.out.println(max(a, b));
            System.out.println(min(a, b));
        }
        //Напишите тут ваш код

    }

    public static int max(int a, int b)
    {
        if (a > b)
            return a;
        else
            return b;
    }

    public static int min(int a, int b)
    {
        if (a < b)
            return a;
        else
            return b;
    }
}
