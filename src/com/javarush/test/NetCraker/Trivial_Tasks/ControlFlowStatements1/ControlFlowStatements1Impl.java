package com.javarush.test.NetCraker.Trivial_Tasks.ControlFlowStatements1;

/**
 * Created by Аркадий on 03.10.2015.
 */
public class ControlFlowStatements1Impl implements ControlFlowStatements1
{

    @Override
    public float getFunctionValue(float x)
    {
        if(x <= 0)
            return 6 - x;
        else
            return 2 * (float) Math.sin((double) x);
    }

    @Override
    public String decodeWeekday(int weekday)
    {
        switch(weekday)
        {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
        }
        return null;
    }

    @Override
    public int[][] initArray()
    {
        int[][] array = new int[8][5];
        for(int j = 0; j < 8; j ++)
            for(int i = 0; i < 5; i++)
                array[j][i] = j * i;
        return array;
    }

    @Override
    public int getMinValue(int[][] array)
    {
        int result = array[0][0];
        for(int[] array1: array)
            for(int i: array1)
                if(i < result)
                    result = i;
        return result;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P)
    {
        BankDeposit deposit = new BankDeposit();
        deposit.amount = 1000;
        while(deposit.amount < 5000)
        {
            deposit.years++;
            deposit.amount *= 1 + (P / 100);
        }
        return deposit;
    }
}
