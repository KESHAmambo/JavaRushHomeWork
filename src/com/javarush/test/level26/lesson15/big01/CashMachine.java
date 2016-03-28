package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by Аркадий on 26.01.2016.
 */
public class CashMachine {
    public static String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            CommandExecutor.execute(Operation.LOGIN, RESOURCE_PATH);
            Operation operation;
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation, RESOURCE_PATH);
            } while (operation != Operation.EXIT);
        } catch(InterruptOperationException e) {
            ConsoleHelper.printExitMessage();
        }
    }
}

/* Problems:
    1) choosing '4' in menu and going !"y" after exiting answer stops machine whatever.
    2) you can't go out of withdrawing if you have no bills of current currency
       and can't take 0;
 */
