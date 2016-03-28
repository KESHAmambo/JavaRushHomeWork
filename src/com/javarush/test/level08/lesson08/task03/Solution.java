package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Malkov", "Ivan");
        map.put("Lavrov", "Dima");
        map.put("Burikin", "Valera");
        map.put("Rumianceva", "Anastasia");
        map.put("Efremof", "Vlad");
        map.put("Lerkov", "Pavel");
        map.put("Belik", "Vlad");
        map.put("Grasch", "Kirill");
        map.put("Navokov", "Artem");
        map.put("Brovkin", "Dmitrii");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();

        while(iter.hasNext())
        {
            if(name.equals(iter.next().getValue()))
                count++;//Напишите тут ваш код
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        int count = 0;

        while(iter.hasNext())
        {
            if(familiya.equals(iter.next().getKey()))
                count++;
        }
        return count;
    }
}
