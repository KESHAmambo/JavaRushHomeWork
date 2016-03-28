package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        String s = "";
        for(int i = 0; i < 6; i++)
        {
            if(fileReader.ready())
                s += (char) fileReader.read();
        }
        int counter = 0;
        String temp = "";
        if(s.charAt(0) == 'w' && !Character.isAlphabetic(s.charAt(5)) && !Character.isDigit(s.charAt(5)))
        {
            temp = s.substring(0, 5);
            if(temp.equals("world"))
                counter++;
        }
        if(fileReader.ready())
        {
            s += (char) fileReader.read();
            Character beg = s.charAt(0);
            Character fin = s.charAt(6);
            if (!Character.isAlphabetic(beg) && !Character.isDigit(beg) && !Character.isAlphabetic(fin) && !Character.isDigit(fin))
            {
                temp = s.substring(1, 6);
                if (temp.equals("world"))
                    counter++;
            }
        }
        while(fileReader.ready())
        {
            s = s.substring(1);
            int data = fileReader.read();
            s += (char) data;
            if(!Character.isAlphabetic(s.charAt(0)) && !Character.isDigit(s.charAt(0)) && !Character.isAlphabetic(s.charAt(6)) && !Character.isDigit(s.charAt(6)))
            {
                temp = s.substring(1, 6);
                if (temp.equals("world"))
                    counter++;
            }
        }
        s = s.substring(1);
        if(s.charAt(5) == 'd' && !Character.isAlphabetic(s.charAt(0)) && !Character.isDigit(s.charAt(0)))
        {
            temp = s.substring(1);
            if(temp.equals("world"))
                counter++;
        }
        System.out.println(counter);
        fileReader.close();
        reader.close();
    }
}
