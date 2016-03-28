package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File(args[0]));
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<Double> valueList = new ArrayList<>();

        while(scan.hasNext())
        {
            String s = scan.nextLine();
            String name = s.substring(0, s.indexOf(' '));
            String valueS = s.substring(s.indexOf(' ') + 1);
            Double value = Double.parseDouble(valueS);
            boolean hasName = false;
            for(int i = 0; i < nameList.size(); i++)
            {
                if(nameList.get(i).equals(name))
                {
                    hasName = true;
                    valueList.set(i, valueList.get(i) + value);
                    break;
                }
            }
            if(!hasName)
            {
                nameList.add(name);
                valueList.add(value);
            }
        }

        for(int j = 0; j < nameList.size(); j++)
        {
            for(int i = 0; i < nameList.size() - 1; i++)
            {
                if(nameList.get(i).compareTo(nameList.get(i + 1)) > 0)
                {
                    String temp1 = nameList.get(i);
                    nameList.set(i, nameList.get(i + 1));
                    nameList.set(i + 1, temp1);
                    Double temp2 = valueList.get(i);
                    valueList.set(i, valueList.get(i + 1));
                    valueList.set(i + 1, temp2);
                }
            }
        }

        for(int i = 0; i < nameList.size(); i++)
            System.out.println(nameList.get(i) + " " + valueList.get(i));
        scan.close();
    }
}
