package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] array = s.toCharArray();

        if((array[0] >= 'a' && array[0] <= 'z') || (array[0] >= 'а' && array[0] <= 'я'))
            array[0] = (char) ((int) array[0] - 32);
        System.out.print(array[0]);

        for(int i = 1; i < array.length; i++)
        {
            if(array[i - 1] == ' ' && ((array[i] >= 'a' && array[i] <= 'z') || (array[i] >= 'а' && array[i] <= 'я')))
                array[i] = (char) (array[i] - 32);

            System.out.print(array[i]);//Напишите тут ваш код
        }

    }


}
