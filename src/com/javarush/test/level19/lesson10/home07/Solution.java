package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);
        ArrayList<String> wordList = new ArrayList<>();

        while(scan.hasNext())
        {
            String temp = scan.nextLine();
            while (temp.indexOf(' ') >= 0)
            {
                wordList.add(temp.substring(0, temp.indexOf(' ')));
                temp = temp.substring(temp.indexOf(' ') + 1);
            }
            wordList.add(temp);
        }

        ArrayList<String> rightWords = new ArrayList<>();
        for(String word: wordList)
            if(word.length() > 6)
                rightWords.add(word);

        for(int i = 0; i < rightWords.size() - 1; i++)
            fileWriter.write(rightWords.get(i) + ",");
        fileWriter.write(rightWords.get(rightWords.size() - 1));

        scan.close();
        fileWriter.close();
    }
}
