package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Lox", new Date("JULY 4 1985"));
        map.put("Umber", new Date("OCTOBER 28 2001"));
        map.put("Lalka", new Date("NOVEMBER 31 1996"));
        map.put("Ivan", new Date("DECEMBER 14 2005"));
        map.put("Misha", new Date("AUGUST 14 1993"));
        map.put("Alex", new Date("DECEMBER 11 1973"));
        map.put("Nicol", new Date("APRIL 9 1986"));
        map.put("Andrey", new Date("JUNE 11 2001"));
        map.put("Kirill", new Date("FEBRUARY 23 1997"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iter = map.entrySet().iterator();
        while(iter.hasNext())
        {
            Map.Entry<String, Date> pair = iter.next();
            int month = pair.getValue().getMonth();
            if(month == 5 || month == 6 || month == 7)
                iter.remove();
        }
    }
}

