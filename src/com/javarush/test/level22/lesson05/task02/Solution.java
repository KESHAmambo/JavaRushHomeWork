package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null)
            throw new TooShortStringException();
        int firstIndex = string.indexOf("\t");
        if(firstIndex == -1)
            throw new TooShortStringException();
        firstIndex = firstIndex + "\t".length();
        int secondIndex = string.indexOf("\t", firstIndex);
        if(secondIndex == -1)
            throw new TooShortStringException();
        return string.substring(firstIndex, secondIndex);
    }

    public static class TooShortStringException extends Exception {
    }
}
