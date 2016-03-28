package com.javarush.test.level22.lesson05.home01Handler;

public class TooShortStringSecondThreadException extends RuntimeException {
    public TooShortStringSecondThreadException(Exception e)
    {
        super(e);
    }
}
