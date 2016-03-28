package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            ArrayList<String> listPV = new ArrayList<String>();
            ArrayList<String> listPar = new ArrayList<String>();
            ArrayList<String> listVal = new ArrayList<String>();
            String s = reader.readLine();

            String subS = s.substring(s.indexOf('?') + 1);
            while(subS.contains("&"))
            {
                listPV.add(subS.substring(0, subS.indexOf('&')));
                subS = subS.substring(subS.indexOf('&') + 1);
            }
            listPV.add(subS);

            for(String str: listPV)
            {
                if(str.contains("="))
                {
                    listPar.add(str.substring(0, str.indexOf('=')));
                    listVal.add(str.substring(str.indexOf('=') + 1));
                }
                else
                {
                    listPar.add(str);
                    listVal.add(null);
                }
            }

            for(String temp: listPar)
                System.out.print(temp + " ");
            System.out.println();

            for(int i = 0; i < listPar.size(); i++)
            {
                String temp = listVal.get(i);
                if(listPar.get(i).equals("obj"))
                {
                    if(isDigit(temp))
                        alert(Double.parseDouble(temp));
                    else
                        alert(temp);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static boolean isDigit(String s)
    {
        try
        {
            Double d = Double.parseDouble(s);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
