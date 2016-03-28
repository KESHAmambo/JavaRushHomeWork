package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while(true)
        {
            String s = reader.readLine();
            if(s.equals("end"))
                break;
            list.add(s);
        }
        sort(list);
        String temp = list.get(0);
        String resultFile = temp.substring(0, temp.lastIndexOf('.'));
        FileOutputStream outputStream = new FileOutputStream(resultFile);
        for(String s: list)
        {
            FileInputStream inputStream = new FileInputStream(s);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            outputStream.write(buffer);
            inputStream.close();
        }
        outputStream.close();
        reader.close();
    }

    public static void sort(ArrayList<String> list)
    {
        for (int j = 0; j < list.size(); j++)
        {
            for (int i = 0; i < list.size() - 1; i++)
            {
                String s1 = list.get(i);
                String s2 = list.get(i + 1);
                int place1 = s1.lastIndexOf('t');
                int place2 = s2.lastIndexOf('t');
                String strDig1 = s1.substring(place1 + 1);
                String strDig2 = s2.substring(place2 + 1);
                int dig1 = Integer.parseInt(strDig1);
                int dig2 = Integer.parseInt(strDig2);
                if(dig1 > dig2)
                {
                    list.set(i, s2);
                    list.set(i + 1, s1);
                }
            }
        }
    }
}
