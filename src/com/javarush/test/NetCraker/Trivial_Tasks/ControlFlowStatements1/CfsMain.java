package com.javarush.test.NetCraker.Trivial_Tasks.ControlFlowStatements1;

/**
 * Created by Аркадий on 03.10.2015.
 */
public class CfsMain
{
    public static void main(String[] args)
    {
        ControlFlowStatements1 cfs = new ControlFlowStatements1Impl();
        System.out.println("GetFunctionValue: " + cfs.getFunctionValue(0));
        System.out.println(cfs.getFunctionValue(1.57f));
        System.out.println("DecodeWeekday: " + cfs.decodeWeekday(3));
        int[][] testArray = cfs.initArray();
        System.out.println("GetMinValue: " + cfs.getMinValue(testArray));
        System.out.println("CalculateBankDeposit: " + cfs.calculateBankDeposit(20));
    }
}
