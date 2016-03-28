package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1                 1   1
строка2                 2   3
строка3                 3   4
                        4
[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan1 = new Scanner(new File(reader.readLine()));
        Scanner scan2 = new Scanner(new File(reader.readLine()));
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        while(scan1.hasNext())
            list1.add(scan1.nextLine());
        while(scan2.hasNext())
            list2.add(scan2.nextLine());
        scan1.close();
        scan2.close();

        while(true)
        {
            try
            {
                if (list1.get(0).equals(list2.get(0)))
                {
                    lines.add(new LineItem(Type.SAME, list1.get(0)));
                    list1.remove(0);
                    list2.remove(0);
                } else if (list1.get(1).equals(list2.get(0)))
                {
                    lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                    list1.remove(0);
                } else if (list1.get(0).equals(list2.get(1)))
                {
                    lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    list2.remove(0);
                }
            }
            catch(IndexOutOfBoundsException e)
            {
                try
                {
                    if (list1.get(0).equals(list2.get(1)))
                    {
                        lines.add(new LineItem(Type.ADDED, list2.get(0)));
                        list2.remove(0);
                    }
                }
                catch(IndexOutOfBoundsException e1)
                {
                    break;
                }
            }
        }
        if(list1.size() > 0)
            lines.add(new LineItem(Type.REMOVED, list1.get(0)));
        else if(list2.size() > 0)
            lines.add(new LineItem(Type.ADDED, list2.get(0)));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
