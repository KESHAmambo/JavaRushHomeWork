package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args)
    {
        try
        {
            Scanner scan = new Scanner(new File(args[0]));
            while(scan.hasNext())
            {
                String s = scan.nextLine();
                int year = Integer.parseInt(s.substring(s.lastIndexOf(' ') + 1));
                s = s.substring(0, s.lastIndexOf(' '));
                int month = Integer.parseInt(s.substring(s.lastIndexOf(' ') + 1));
                s = s.substring(0, s.lastIndexOf(' '));
                int day = Integer.parseInt(s.substring(s.lastIndexOf(' ') + 1));
                String name = s.substring(0, s.lastIndexOf(' '));
                GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
                Date birthday = calendar.getTime();
                PEOPLE.add(new Person(name, birthday));
            }
            scan.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
