package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Аркадий on 10.07.2015.
 */
public class USD extends Money
{
    public String getCurrencyName()
    {
        return "USD";
    }

    public USD(double amount)
    {
        super(amount);
    }
}
