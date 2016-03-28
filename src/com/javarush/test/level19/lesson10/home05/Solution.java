package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
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
        {
            char[] array = word.toCharArray();
            boolean hasDigit = false;
            for(char c: array)
                if(Character.isDigit(c))
                {
                    hasDigit = true;
                    break;
                }
            if(hasDigit)
                rightWords.add(word);
        }

        for(String word: rightWords)
            fileWriter.write(word + " ");

        scan.close();
        fileWriter.close();
    }
}
