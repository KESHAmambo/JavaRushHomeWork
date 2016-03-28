package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while(inputStream.available() > 0)
        {
            int data = inputStream.read();
            map.put(data, 1);
        }

        ArrayList<Integer> allDifBytes = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> pair: map.entrySet())
        {
            allDifBytes.add(pair.getKey());
        }

        for(int j = 0; j < allDifBytes.size(); j++)
        {
            for(int i = 0; i < allDifBytes.size() - 1; i++)
            {
                if(allDifBytes.get(i) > allDifBytes.get(i + 1))
                {
                    Integer temp = allDifBytes.get(i);
                    allDifBytes.set(i, allDifBytes.get(i + 1));
                    allDifBytes.set(i + 1, temp);
                }
            }
        }

        for(Integer i: allDifBytes)
            System.out.print(i + " ");

        inputStream.close();
    }
}
