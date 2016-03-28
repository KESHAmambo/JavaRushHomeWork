package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution
{
    public Solution()
    {

    }

    public Solution(double i, int j)
    {

    }

    public Solution(double d, double b)
    {}

    protected Solution(String s)
    {

    }
    protected Solution(String s, int a)
    {

    }

    protected Solution(String s, double a)
    {

    }

    private Solution(int i)
    {

    }

    private Solution(int i, String s)
    {

    }

    private Solution(int i, double d)
    {

    }

    Solution(float f)
    {

    }

    Solution(float f, int a)
    {

    }

    Solution(float f, String s)
    {

    }
}

