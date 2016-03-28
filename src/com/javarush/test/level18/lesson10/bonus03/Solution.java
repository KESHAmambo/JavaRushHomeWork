package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Scanner scan = new Scanner(new File(fileName));
        ArrayList<String> list = new ArrayList<String>();
        while(scan.hasNext())
        {
            list.add(scan.nextLine());
        }
        scan.close();
        ArrayList<Integer> idList = new ArrayList<>();
        for (String aList : list)
        {
            String sub = aList.substring(0, 8);
            char[] temp = sub.toCharArray();
            String res = "";
            for(char aTemp : temp)
            {
                if (aTemp != ' ')
                    res += aTemp;
            }
            int id = Integer.parseInt(res);
            idList.add(id);
        }
        for(int i = 0; i < list.size(); i++)
        {
            list.set(i, list.get(i).substring(8));
        }

        switch(args[0])
        {
            case("-u"):
            {
                String s = createString(args);
                int id = Integer.parseInt(args[1]);
                FileWriter fileWriter = new FileWriter(fileName);
                for(int i = 0; i < list.size(); i++)
                {
                    if(id == idList.get(i))
                    {
                        String result = String.format("%-8d%s", id, s);
                        fileWriter.write(result);
                    }
                    else
                    {
                        String result = String.format("%-8d%s", idList.get(i), list.get(i));
                        fileWriter.write(result);
                    }
                    fileWriter.write(System.lineSeparator());
                }
                fileWriter.close();
                break;
            }
            case("-d"):
            {
                FileWriter fileWriter = new FileWriter(fileName);
                int id = Integer.parseInt(args[1]);
                for(int i = 0; i < list.size(); i++)
                {
                    if(idList.get(i) == id)
                        continue;
                    String result = String.format("%-8d%s", idList.get(i), list.get(i));
                    fileWriter.write(result);
                    fileWriter.write(System.lineSeparator());
                }
                fileWriter.close();
            }
        }
        reader.close();
    }

    public static String createString(String[] args)
    {
        return String.format("%-30s%-8s%-4s", args[2], args[3], args[4]);
    }
}
