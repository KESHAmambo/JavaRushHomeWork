package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }


    public static void sort(String[] array)
    {
        for(int j = 0; j < array.length; j++)
        {
            for(int i = 0; i < array.length - 1; i++)
            {
                if(isNumber(array[i]))
                {
                    int temp1 = Integer.parseInt(array[i]);
                    int secondPlace = i + 1;
                    while(secondPlace < array.length && !isNumber(array[secondPlace]))
                    {
                        secondPlace++;
                    }
                    if(secondPlace < array.length)
                    {
                        int temp2 = Integer.parseInt(array[secondPlace]);
                        if (temp1 < temp2)
                        {
                            array[i] = String.valueOf(temp2);
                            array[secondPlace] = String.valueOf(temp1);
                        }
                    }
                }
                else
                {
                    int secondPlace = i + 1;
                    while(secondPlace < array.length && isNumber(array[secondPlace]))
                    {
                        secondPlace++;
                    }
                    if(secondPlace < array.length && isGreaterThen(array[i], array[secondPlace]))
                    {
                        String temp = array[i];
                        array[i] = array[secondPlace];
                        array[secondPlace] = temp;
                    }
                }
            }
        }
        /*ArrayList<String> listStr = new ArrayList<String>();
        ArrayList<Integer> listInt = new ArrayList<Integer>();
        for(int i = 0; i < array.length; i++)// separation into two arrays: listStr & listInt
        {
            if(isNumber(array[i]))
                listInt.add(Integer.parseInt(array[i]));
            else
                listStr.add(array[i]);//Напишите тут ваш код
        }

        for(int j = 0; j < listInt.size(); j++)// listInt sorting
        {
            for(int i = 0; i < listInt.size() - 1; i++)
            {
                if(listInt.get(i + 1) > listInt.get(i))
                {
                    int temp = listInt.get(i);
                    listInt.set(i, listInt.get(i + 1));
                    listInt.set(i + 1, temp);
                }
            }
        }

        for(int j = 0; j < listStr.size(); j++)// listStr sorting
        {
            for(int i = 0; i < listStr.size() - 1; i++)
            {
                if(isGreaterThen(listStr.get(i), listStr.get(i + 1)))
                {
                    String temp = listStr.get(i);
                    listStr.set(i, listStr.get(i + 1));
                    listStr.set(i + 1, temp);
                }
            }
        }

        for(int i = 0; i < listStr.size(); i++)// replacing old items in array to sort items
        {
            array[i] = listStr.get(i);
        }
        for(int i = listStr.size(); i < array.length; i++)
        {
            array[i] = String.valueOf(listInt.get(i - listStr.size()));// converting from int to String
        }*/
    }


    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
