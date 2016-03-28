package com.javarush.test.level22.lesson05.home01Handler;

public class TooShortStringFirstThreadException extends RuntimeException {
    public TooShortStringFirstThreadException(Exception e)
    {
        super(e);
    }
}
