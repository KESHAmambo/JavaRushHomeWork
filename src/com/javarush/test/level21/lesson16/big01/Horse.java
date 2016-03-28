package com.javarush.test.level21.lesson16.big01;

import java.util.Date;
import java.util.Random;

/**
 * Created by Аркадий on 13.09.2015.
 */
public class Horse
{
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move()
    {
        distance += speed * Math.random();
    }

    public void print()
    {
        int a = (int) distance;
        String result = "";
        for(int i = 0; i < a; i++)
            result += ".";
        result += name;
        System.out.println(result);
    }

    public String getName()
    {
        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }
}