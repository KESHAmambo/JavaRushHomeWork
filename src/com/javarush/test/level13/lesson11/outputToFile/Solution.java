package com.javarush.test.level13.lesson11.outputToFile;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter file = new FileWriter(reader.readLine());


        while(true)
        {
            String temp = reader.readLine();
            file.write(temp);
            file.write(System.lineSeparator());
            if(temp.equals("exit"))
                break;
            //[] array = temp.toCharArray();
            //for(char symbol: array)
            //    file.write(symbol);
            //file.write(System.lineSeparator());
        }

        file.close();
    }
}
