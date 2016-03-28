package com.javarush.test.xAttempts;

/**
 * Created by ������� on 26.10.2015.
 */
public class TeorInf
{
    static double[][] array = new double[][]
            //0      1      2      x
            {{0.25,  0.5,   0.25},
             {0.2,   0.4,   0.4},
             {0.308, 0.308, 0.385}};

    public static void main(String[] args)
    {
        System.out.println("2 0 1");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    double result = 1;
                    result *= array[i][2];
                    result *= array[j][0];
                    result *= array[k][1];
                    System.out.print(i + " " + j + " " + k + " : ");
                    String s = String.format("%.4f", result);
                    System.out.println(s);
                }
            }
        }

        System.out.println("\n0 2 1");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    double result = 1;
                    result *= array[i][0];
                    result *= array[j][2];
                    result *= array[k][1];
                    System.out.print(i + " " + j + " " + k + " : ");
                    String s = String.format("%.4f", result);
                    System.out.println(s);
                }
            }
        }

        System.out.println("\n 0 1 0");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    double result = 1;
                    result *= array[i][0];
                    result *= array[j][1];
                    result *= array[k][0];
                    System.out.print(i + " " + j + " " + k + " : ");
                    String s = String.format("%.4f", result);
                    System.out.println(s);
                }
            }
        }
    }
}
