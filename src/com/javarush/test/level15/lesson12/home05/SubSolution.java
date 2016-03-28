package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Аркадий on 12.07.2015.
 */
public class SubSolution extends Solution
{


    public SubSolution(double i, int j)
    {
        super(i, j);
    }
    public SubSolution(double d, double b)
    {
        super(d, b);
    }
    public SubSolution()
    {
        super();
    }

    protected SubSolution(String s, double a)
    {
        super(s, a);
    }
    protected SubSolution(String s)
    {
        super(s);
    }
    protected SubSolution(String s, int a)
    {
        super(s, a);
    }

    SubSolution(float f, String s)
    {
        super(f, s);
    }
    SubSolution(float f, int a)
    {
        super(f, a);
    }
    SubSolution(float f)
    {
        super(f);
    }

    private SubSolution(int i)
    {

    }
    private SubSolution(int i, double d)
    {}
    private SubSolution(int i, String s)
    {}
}
