package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = new int[128];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        while(inputStream.available() > 0)
        {
            int data = inputStream.read();
            array[data]++;
        }

        int maxVal = array[0];
        for(int i = 1; i < array.length; i++)
        {
            if(array[i] > maxVal)
                maxVal = array[i];
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == maxVal)
                list.add(i);
        }

        for(Integer i: list)
        System.out.print(i + " ");

        inputStream.close();
    }
}
