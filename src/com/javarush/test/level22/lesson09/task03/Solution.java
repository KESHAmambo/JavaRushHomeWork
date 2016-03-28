package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        Scanner scan = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();

        StringBuilder word = new StringBuilder();
        while(scan.hasNext())
        {
            String s = scan.nextLine();
            for(int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if(c == ' ')
                {
                    list.add(word.toString());
                    word = new StringBuilder();
                }
                else if(i == s.length() - 1)
                {
                    word.append(c);
                    list.add(word.toString());
                    word = new StringBuilder();
                }
                else
                    word.append(c);
            }
        }

        String[] array = new String[list.size()];
        for(int i = 0; i < list.size(); i++)
            array[i] = list.get(i);

        StringBuilder result = getLine(array);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
            return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1)
            return new StringBuilder(words[0]);

        ArrayList<String> list = new ArrayList<>();
        for (String word : words) list.add(word);

        ArrayList<String> allStrings = new ArrayList<>();
        create(allStrings, list, words.length, "");

        for(String s: allStrings)
        {
            if(isRightString(s))
                return new StringBuilder(s);
        }

        return new StringBuilder();
    }

    public static void create(ArrayList<String> allStrings, ArrayList<String> list, int length, String result)
    {
        String temp;
        for (int i = 0; i < list.size(); i++)
        {
            temp = result;
            if(temp.length() == 0)
                temp = list.get(i);
            else
                temp += " " + list.get(i);

            if(wordCount(temp) == length)
                allStrings.add(temp);
            else
            {
                ArrayList<String> nextList = new ArrayList<>();
                for (int j = 0; j < list.size(); j++)
                    if (j != i)
                        nextList.add(list.get(j));
                create(allStrings, nextList, length, temp);
            }
        }
    }

    public static boolean isRightString(String s)
    {
        if(s.indexOf(' ') == -1)
            return true;
        int index = 0;
        while(true)
        {
            index = s.indexOf(' ', index + 1);
            if(index == -1)
                return true;
            char a = s.toLowerCase().charAt(index - 1);
            char b = s.toLowerCase().charAt(index + 1);
            if(a != b)
                return false;
        }
    }

    public static int wordCount(String s)
    {
        if(s.indexOf(' ') == -1)
            return 1;
        int index = 0;
        int counter = 0;
        while(true)
        {
            counter++;
            index = s.indexOf(' ', index + 1);
            if(index == -1)
                return counter;
        }
    }
}
