package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file = new File(reader.readLine());

        Scanner scan = new Scanner(file);

        ArrayList<Integer> list = new ArrayList<Integer>();

        while(scan.hasNextInt())
        {
            int temp = scan.nextInt();
            if (temp % 2 == 0)
                list.add(temp);
        }

        for(int j = 0; j < list.size(); j++)
        {
            for(int i = 0; i < list.size() - 1; i++)
            {
                if(list.get(i) > list.get(i + 1))
                {
                    int temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }

        for(Integer i: list)
            System.out.println(i);

    }
}
