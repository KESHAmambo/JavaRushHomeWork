package com.javarush.test.level14.lesson06.home01;

/**
 * Created by ������� on 10.07.2015.
 */
public class BelarusianHen extends Hen implements Country
{
    public int getCountOfEggsPerMonth()
    {
        return 60;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
