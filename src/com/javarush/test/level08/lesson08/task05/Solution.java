package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for(Map.Entry<String, String> pair: map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
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
        return map;//Напишите тут ваш код
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        Set<String> set = new HashSet<String>();

        for(Map.Entry<String, String> pair: copy.entrySet())
        {
            map.remove(pair.getKey());

            /*System.out.println("---" + pair.getKey() + pair.getValue() + ":");
            for(Map.Entry<String, String> pm: map.entrySet())
            {
                System.out.println(pm.getKey() + " " + pm.getValue());
            }
            System.out.println("___");*/

            if(map.containsValue(pair.getValue()))
            {
                removeItemFromMapByValue(map, pair.getValue());
                set.add(pair.getValue());
                /*System.out.println("!!!!!!!!!!" + pair.getKey() + pair.getValue() + ":");
                for (Map.Entry<String, String> pm : map.entrySet())
                {
                    System.out.println(pm.getKey() + " " + pm.getValue());
                }
                System.out.println("(((");*/
            }
            else if(!set.contains(pair.getValue()))
                map.put(pair.getKey(), pair.getValue());

            /*System.out.println("+++++" + pair.getKey() + pair.getValue() + ":");
            for (Map.Entry<String, String> pm : map.entrySet())
            {
                System.out.println(pm.getKey() + " " + pm.getValue());
            }
            System.out.println("(((");*/
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
            {
                map.remove(pair.getKey());
            }
        }
    }
}
