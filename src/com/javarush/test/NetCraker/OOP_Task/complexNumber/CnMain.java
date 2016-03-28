package com.javarush.test.NetCraker.OOP_Task.complexNumber;

import java.util.Arrays;

/**
 * Created by Аркадий on 10.10.2015.
 */
public class CnMain
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        ComplexNumber c0 = new ComplexNumberImpl();//"-5+2i", 1+i", "+4-i", "i", "-3i", "3"
        ComplexNumber c1 = new ComplexNumberImpl();
        ComplexNumber c2 = new ComplexNumberImpl();
        ComplexNumber c3 = new ComplexNumberImpl();
        ComplexNumber c4 = new ComplexNumberImpl();
        ComplexNumber c5 = new ComplexNumberImpl();
        ComplexNumber c6 = new ComplexNumberImpl();
        ComplexNumber c7 = new ComplexNumberImpl();
        ComplexNumber[] array = new ComplexNumber[] {c1, c2, c3, c4, c5, c6, c7, c0};
        System.out.println(Arrays.asList(array));
        c1.set("-4+2.5i");
        c2.set("1+1.0i");
        c3.set("1.0i");
        c4.set("-3i");
        c5.set("4-i");
        c6.set(3, 0);
        c7.set(4, -1);
        System.out.println(Arrays.asList(array));
        c1.sort(array);
        System.out.println(Arrays.asList(array));
    }
}
