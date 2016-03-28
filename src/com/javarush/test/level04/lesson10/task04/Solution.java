package com.javarush.test.level04.lesson10.task04;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в одной строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    int i = 10;
    int j = 10;
    while (i > 0)
    {
        while (j > 0)
        {
            System.out.print("S");
            j--;//Напишите тут ваш код
        }
        System.out.println();
        j = 10;
        i--;
    }

    }
}
