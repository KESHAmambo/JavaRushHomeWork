package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        Scanner scan = new Scanner(file);
        ArrayList<StringBuilder> list = new ArrayList<>();

        StringBuilder word = new StringBuilder();
        while(scan.hasNext())
        {
            String s = scan.nextLine();
            for(int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if(c == ' ')
                {
                    list.add(word);
                    word = new StringBuilder();
                }
                else if(i == s.length() - 1)
                {
                    word.append(c);
                    list.add(word);
                    word = new StringBuilder();
                }
                else
                    word.append(c);
            }
        }

        for(int i = 0; i < list.size(); i++)
        {
            String temp1 = list.get(i).reverse().toString();
            for(int j = i + 1; j < list.size(); j++)
            {
                String temp2 = list.get(j).toString();
                if(temp1.equals(temp2))
                {
                    Pair p = new Pair();
                    p.first = list.get(i).reverse().toString();
                    p.second = list.get(j).toString();
                    result.add(p);
                    list.remove(i);
                    list.remove(j - 1);
                    i--;
                    break;
                }
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
