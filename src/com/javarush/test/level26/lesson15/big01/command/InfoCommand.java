package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

/**
 * Created by Аркадий on 27.01.2016.
 */
class InfoCommand implements Command {
    private ResourceBundle res;
    @Override
    public void execute(String path) {
        res = ResourceBundle.getBundle(path + "info_en");
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> cmCol = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        boolean hasMoney = false;
        for(CurrencyManipulator cm: cmCol) {
            if(cm.hasMoney()) {
                hasMoney = true;
                break;
            }
        }
        if(!hasMoney) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
            return;
        }
        for(CurrencyManipulator cm: cmCol) {
            if(cm.getTotalAmount() != 0) {
                ConsoleHelper.writeMessage(cm.getCurrencyCode() + " - " + cm.getTotalAmount());
            }
        }
    }
}
