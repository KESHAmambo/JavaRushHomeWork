package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(new File(reader.readLine()));
        ArrayList<String> rightStr = new ArrayList<>();
        while(scan.hasNext())
        {
            String s = scan.nextLine();

            String temp = s;
            ArrayList<String> wordList = new ArrayList<>();
            while(temp.indexOf(' ') >= 0)
            {
                wordList.add(temp.substring(0, temp.indexOf(' ')));
                temp = temp.substring(temp.indexOf(' ') + 1);
            }
            wordList.add(temp);

            int counter = 0;
            for(String word: wordList)
            {
                for(String w: words)
                {
                    if(word.equals(w))
                        counter++;
                }
            }

            if(counter == 2)
                rightStr.add(s);
        }

        for(String s: rightStr)
            System.out.println(s);
        scan.close();
        reader.close();
    }
}
