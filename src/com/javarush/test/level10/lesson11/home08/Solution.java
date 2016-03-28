package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;
import java.util.List;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] arrayOfStringList = new ArrayList[2];//напишите тут ваш код
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("lalka");
        list1.add("Dodik");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("moshkara");
        list2.add("petuxi");
        arrayOfStringList[0] = list1;
        arrayOfStringList[1] = list2;
        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}