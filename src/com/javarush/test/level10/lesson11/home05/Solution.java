package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        //char temp = (char) 1072;
        //System.out.println(temp);
        //int b1 = temp;
        //System.out.println(b1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        int[] repNum = new int[34];

        for (String s : list)
        {
            char[] temp = s.toCharArray();
            for (char aTemp : temp)
            {
                if ((aTemp >= 1072 && aTemp <= 1103) || aTemp == 1105)
                    repNum[(int) aTemp - 1072]++;
            }
        }

        //Output
        for(int i = 0; i < 6; i++)
        {
            System.out.println(alphabet.get(i) + " " + repNum[i]);//напишите тут ваш код
        }
        System.out.println(alphabet.get(6) + " " + repNum[33]);
        for(int i = 6; i < alphabet.size() - 1; i++)
        {
            System.out.println(alphabet.get(i + 1) + " " + repNum[i]);
        }

    }

}
