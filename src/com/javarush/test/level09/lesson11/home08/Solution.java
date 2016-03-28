package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        int[] list1 = new int[] {1, 2, 3 , 4 ,5};
        int[] list2 = new int[] {1, 2};
        int[] list3 = new int[] {1, 2, 3, 4};
        int[] list4 = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] list5 = new int[0];
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);

        return list;//Написать тут ваш код
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
