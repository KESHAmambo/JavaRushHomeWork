package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream  = new FileInputStream(args[0]);
        int counter = 0;
        while(inputStream.available() > 0)
        {
            int data = inputStream.read();
            if((data >= 'a' && data <= 'z') || (data >= 'A' && data <= 'Z'))
                counter++;
        }
        System.out.println(counter);
        inputStream.close();
    }
}
