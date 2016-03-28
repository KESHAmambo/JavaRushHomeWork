package com.javarush.test.level04.lesson13.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sm = reader.readLine();
        String sn = reader.readLine();
        int m = Integer.parseInt(sm);
        int n = Integer.parseInt(sn);

        for(int i = 0; i < m; i++)
        {//Напишите тут ваш код
            for (int j = 0; j < n; j++)
                System.out.print(8);
            System.out.println();
        }

    }
}
