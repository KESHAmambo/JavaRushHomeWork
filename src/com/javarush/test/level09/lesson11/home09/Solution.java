package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> map = new HashMap<String, Cat>();
        map.put("A", new Cat("A"));
        map.put("B", new Cat("B"));
        map.put("C", new Cat("C"));
        map.put("D", new Cat("D"));
        map.put("E", new Cat("E"));
        map.put("F", new Cat("F"));
        map.put("G", new Cat("G"));
        map.put("H", new Cat("H"));
        map.put("I", new Cat("I"));
        map.put("J", new Cat("J"));

        return map;//Напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Iterator<Map.Entry<String, Cat>> iter = map.entrySet().iterator();
        Set<Cat> set = new HashSet<Cat>();

        while(iter.hasNext())
        {
            set.add(iter.next().getValue());//Напишите тут ваш код
        }

        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
