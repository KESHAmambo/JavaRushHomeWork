package com.javarush.test.level08.lesson08.task01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<String>();
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < 20; i++)
        {
            list.add("Л" + i);
        }
        set.addAll(list);
        return set;//Напишите тут ваш код
    }
}
