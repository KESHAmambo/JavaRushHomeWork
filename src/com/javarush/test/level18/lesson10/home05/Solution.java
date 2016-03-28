package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(new File(reader.readLine())).useLocale(Locale.ENGLISH);
        FileWriter fileWriter = new FileWriter(reader.readLine());
        while(scan.hasNext())
        {
            String s = (int) Math.round(scan.nextDouble()) + " ";
            fileWriter.write(s);
        }
        scan.close();
        fileWriter.close();
        reader.close();
    }
}
