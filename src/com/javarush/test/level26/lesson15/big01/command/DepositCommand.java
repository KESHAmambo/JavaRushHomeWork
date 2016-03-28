package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Аркадий on 27.01.2016.
 */
class DepositCommand implements Command {
    private ResourceBundle res;
    @Override
    public void execute(String path) throws InterruptOperationException {
        res = ResourceBundle.getBundle(path + "deposit_en");
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        while(true) {
            try {
                CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
                String[] input = ConsoleHelper.getValidTwoDigits(currencyCode);
                int nominal = Integer.parseInt(input[0]);
                int count = Integer.parseInt(input[1]);
                cm.addAmount(nominal, count);
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), nominal * count, currencyCode));
                break;
            } catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
    }
}
