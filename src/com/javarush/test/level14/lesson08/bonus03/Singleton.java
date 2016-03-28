package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Аркадий on 10.07.2015.
 */
public class Singleton
{
    private static Singleton singleton;
    static Singleton getInstance()
    {
        return singleton;
    }

    private Singleton()
    {

    }
}
