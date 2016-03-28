package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        String s = "";
        while(fileReader.ready())
        {
            Character c = (char) fileReader.read();
            if(c == ' ')
            {
                if(isDig(s))
                    fileWriter.write(s + " ");
                s = "";
            }
            else
                s += c;
        }
        if(isDig(s))
            fileWriter.write(s);
        fileReader.close();
        fileWriter.close();
        reader.close();
    }

    public static boolean isDig(String s)
    {
        try
        {
            int i = Integer.parseInt(s);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
