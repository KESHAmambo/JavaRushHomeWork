package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by Аркадий on 28.01.2016.
 */
class LoginCommand implements Command {
    private ResourceBundle validCreditCards;
    private ResourceBundle res;
    @Override
    public void execute(String path) throws InterruptOperationException {
        validCreditCards = ResourceBundle.getBundle(path + "verifiedCards");
        res = ResourceBundle.getBundle(path + "login_en");
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));
        while(true) {
            try {
                String enteredCard = ConsoleHelper.readString();
                if (enteredCard == null || !enteredCard.matches("[0-9]{12}")) {
                    throw new NumberFormatException();
                }
                String pin = validCreditCards.getString(enteredCard);
                String enteredPin = ConsoleHelper.readString();
                if (enteredPin == null || !enteredPin.matches("[0-9]{4}")) {
                    throw new NumberFormatException();
                }
                if(!pin.equals(enteredPin)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), enteredCard));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), enteredCard));
                break;
            } catch(NumberFormatException | MissingResourceException e) {
                System.out.println(res.getString("try.again.with.details"));
            }
        }
    }
}
