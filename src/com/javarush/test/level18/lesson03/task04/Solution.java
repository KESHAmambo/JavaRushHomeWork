package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int[] array = new int[128];
        while(inputStream.available() > 0)
        {
            int data = inputStream.read();
            array[data]++;
        }
        int minVal = array[0];
        for(int i = 1; i < array.length; i++)
        {
            if(minVal == 0)
                minVal = array[i];
            if(array[i] < minVal && array[i] != 0)
                minVal = array[i];
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == minVal)
                list.add(i);
        }

        for(Integer i: list)
            System.out.print(i + " ");

        inputStream.close();
    }
}
