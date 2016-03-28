package com.javarush.test.level30.lesson02.task01;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if(s == null) return null;

        if(s.matches("0x\\d+")) {
            s = convertFrom16System(Integer.parseInt(s.substring(2, s.length())));
            return s;
        } else if(s.matches("0b\\d+")) {
            s = convertFrom2System(Integer.parseInt(s.substring(2, s.length())));
            return s;
        } else if(s.matches("0\\d+")) {
            s = convertFrom8System(Integer.parseInt(s.substring(1, s.length())));
            return s;
        } else if(s.matches("\\d+")) {
            return s;
        }
        return null;
    }

    private static String convertFrom16System(Integer digit) {
        int modulo;
        int power = 0;
        Integer result = 0;
        while(true) {
            modulo = digit % 10;
            result += modulo * (int) Math.pow(16, power++);
            if((digit /= 10) == 0) break;
        }
        return result.toString();
    }

    private static String convertFrom8System(Integer digit) {
        int modulo;
        int power = 0;
        Integer result = 0;
        while(true) {
            modulo = digit % 10;
            result += modulo * (int) Math.pow(8, power++);
            if((digit /= 10) == 0) break;
        }
        return result.toString();
    }

    private static String convertFrom2System(Integer digit) {
        int modulo;
        int power = 0;
        Integer result = 0;
        while(true) {
            modulo = digit % 10;
            result += modulo * (int) Math.pow(2, power++);
            if((digit /= 10) == 0) break;
        }
        return result.toString();
    }
}
