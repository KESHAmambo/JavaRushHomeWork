package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int allCounter = 0;
        int spaces = 0;
        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            allCounter++;
            if(data == ' ')
                spaces++;
        }
        fileInputStream.close();
        double result =(double)((int)(((double)spaces / allCounter) * 10000)) / 100;
        System.out.println(result);
    }
}
