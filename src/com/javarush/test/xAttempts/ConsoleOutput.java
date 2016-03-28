package com.javarush.test.xAttempts;

import java.io.Console;

/**
 * Created by ������� on 03.10.2015.
 */
public class ConsoleOutput
{
    public static void main(String[] args)
    {
        Console c = System.console();
        String s = c.readLine("My output: ");
        System.out.println(s);
    }
}
