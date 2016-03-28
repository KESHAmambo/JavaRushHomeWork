package com.javarush.test.xAttempts;

import java.util.Date;

/**
 * Created by ������� on 21.04.2015.
 */
public class IsItTimeYet
{
    public static void main(String[] args) throws Exception
    {
        Date startTime = new Date();
        long endTime = startTime.getTime() + 5000;
        System.out.println(endTime);
        Date endDate = new Date(endTime);

        Thread.sleep(3000);

        Date currentTime = new Date();
        if (currentTime.before(endDate))
        {
            System.out.println("It's not time yet!");
    }
    }
}