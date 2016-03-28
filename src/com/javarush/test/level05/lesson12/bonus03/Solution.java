package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int maximum;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int a = Integer.parseInt(reader.readLine());
        maximum = a;

        for(int i = 0; i < N - 1; i++)
        {
            a = Integer.parseInt(reader.readLine());
            if(maximum < a)
                maximum = a;
        }

        System.out.println(maximum);
    }
}
