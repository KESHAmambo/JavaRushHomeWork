package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Аркадий on 26.01.2016.
 */
public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.common_en");
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String result = reader.readLine();
            if("exit".equals(result.toLowerCase())) {
                throw new InterruptOperationException();
            }
            return result;
        } catch (IOException ignore) {
            return null;
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("choose.currency.code"));
        while(true) {
            String code = readString();
            if(code == null || code.length() != 3) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            } else {
                return code.toUpperCase();
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode)
            throws InterruptOperationException, NumberFormatException,
            NullPointerException, ArrayIndexOutOfBoundsException {
        ConsoleHelper.writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        String input = readString();
        String[] result = input.split(" ", 2);
        if(Integer.parseInt(result[0]) >= 0 && Integer.parseInt(result[1]) >= 0) {
            return result;
        } else {
            throw new NumberFormatException();
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while(true) {
            try {
                ConsoleHelper.writeMessage(res.getString("choose.operation") +
                "\n" + res.getString("operation.INFO") +
                "\n" + res.getString("operation.DEPOSIT") +
                "\n" + res.getString("operation.WITHDRAW") +
                "\n" + res.getString("operation.EXIT"));
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            } catch(NullPointerException | IllegalArgumentException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}
