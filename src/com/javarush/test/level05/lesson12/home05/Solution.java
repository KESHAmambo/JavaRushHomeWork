package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution

{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String snumber = reader.readLine();
        int sum = 0;
        while(!(snumber.equals("сумма")))
        {
            int number = Integer.parseInt(snumber);
            sum += number;
            snumber = reader.readLine();//Напишите тут ваш код
        }

        System.out.println(sum);
    }
}
