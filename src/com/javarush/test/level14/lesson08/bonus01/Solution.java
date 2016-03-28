package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            List<Number> list = null;
            list.add(5);
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] array = new int[1];
            System.out.println(array[1]);
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new ClassNotFoundException();
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new NoSuchFieldException();
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new NoSuchMethodException();
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new ClassCastException();
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalArgumentException();
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IndexOutOfBoundsException();
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new NegativeArraySizeException();
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }
    }
}
