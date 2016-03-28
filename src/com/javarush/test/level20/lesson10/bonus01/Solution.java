package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Date;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = N; i > 0; i--)
        {
            int temp = i;
            boolean right = true;
            for(int j = 0; j < ("" + i).length() - 1; j++)
            {
                int a = temp % 10;
                int b = temp / 10 % 10;
                if(a < b)
                {
                    right = false;
                    break;
                }
                temp = temp / 10;
            }

            if(right)
            {
                boolean added = false;
                int sum = find(i);
                if(isArm(sum) && !list.contains(sum) && sum <= N && sum > 0)
                {
                    list.add(sum);
                    added = true;
                }
                if(!added)
                {
                    sum = find(i * 10);
                    if (isArm(sum) && !list.contains(sum) && sum <= N && sum > 0)
                    {
                        list.add(sum);
                        added = true;
                    }
                }
                if(!added)
                {
                    sum = find(i * 100);
                    if (isArm(sum) && !list.contains(sum) && sum <= N && sum > 0)
                        list.add(sum);
                }
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }
        for(int j = 0; j < result.length; j++)// sort
        {
            for(int i = 0; i < result.length - 1; i++)
            {
                if(result[i] > result[i + 1])
                {
                    int temp = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = temp;
                }
            }
        }
        return result;
    }

    public static boolean isArm(int a)
    {
        int power = ("" + a).length();
        int sum = 0;
        int rem = a % 10;
        int ost = a / 10;
        while(rem != 0 || ost > 0)
        {
            int mul = rem;
            for(int j = 1; j < power; j++)
                rem = rem * mul;
            sum += rem;
            rem = ost % 10;
            ost = ost / 10;
        }
        return sum == a;
    }

    public static int find(int i)
    {
        int power = ("" + i).length();
        int sum = 0;
        int rem = i % 10;
        int ost = i / 10;
        while(rem != 0 || ost > 0)
        {
            int mul = rem;
            for(int j = 1; j < power; j++)
                rem = rem * mul;
            sum += rem;
            rem = ost % 10;
            ost = ost / 10;
        }
        return sum;
    }
}
