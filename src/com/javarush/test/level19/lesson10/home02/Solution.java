package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
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

        Double maxValue = valueList.get(0);
        for (Double value : valueList)
        {
            if (value > maxValue)
                maxValue = value;
        }
        ArrayList<String> resultList = new ArrayList<>();
        for(int i = 0; i < valueList.size(); i++)
        {
            if(valueList.get(i).equals(maxValue))
                resultList.add(nameList.get(i));
        }

        for(String s: resultList)
            System.out.println(s);
        scan.close();
    }
}
