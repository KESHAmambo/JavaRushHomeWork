package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Аркадий on 27.01.2016.
 */
interface Command {
    void execute(String path) throws InterruptOperationException;
}
