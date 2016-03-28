package com.javarush.test.xAttempts;

/**
 * Created by ������� on 11.10.2015.
 */
public abstract class Test
{
    static class A{
        String x = "A";
        void printX()
        {
            System.out.println(x);
        }
    }

    static class B extends A{
        String x = "B";
        B(){
        }
    }

    public static void main(String[] args)
    {
        A b = new B();
        System.out.println(b.x);
    }
}
