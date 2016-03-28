package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

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
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Scanner scan = new Scanner(new File(fileName));
        ArrayList<String> list = new ArrayList<String>();
        while(scan.hasNext())
        {
            list.add(scan.nextLine());
        }
        scan.close();
        int maxID = 0;
        for(String s: list)
        {
            String sub = s.substring(0, 8);
            char[] temp = sub.toCharArray();
            String res = "";
            for (int i = 0; i < temp.length; i++)
            {
                if (temp[i] != ' ')
                    res += temp[i];
            }
            int id = Integer.parseInt(res);
            if(id > maxID)
                maxID = id;
        }

        switch(args[0])
        {
            case("-c"):
            {
                maxID++;
                String result = String.format("%-8d%s", maxID, createString(args));
                FileWriter fileWriter = new FileWriter(fileName);
                for(String s: list)
                {
                    fileWriter.write(s);
                    fileWriter.write(System.lineSeparator());
                }
                fileWriter.write(result);
                fileWriter.close();
            }
        }
        reader.close();
    }

    public static String createString(String[] args)
    {
        return String.format("%-30s%-8s%-4s", args[1], args[2], args[3]);
    }
}
