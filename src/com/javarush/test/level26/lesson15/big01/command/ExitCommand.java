package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Аркадий on 27.01.2016.
 */
class ExitCommand implements Command {
    private ResourceBundle res;
    @Override
    public void execute(String path) throws InterruptOperationException {
        res = ResourceBundle.getBundle(path + "exit_en");
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        if(res.getString("yes").equals(ConsoleHelper.readString())) {
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }
    }
}
