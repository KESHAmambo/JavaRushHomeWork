package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Аркадий on 27.01.2016.
 */
class WithdrawCommand implements Command {
    private ResourceBundle res;
    @Override
    public void execute(String path) throws InterruptOperationException {
        res = ResourceBundle.getBundle(path + "withdraw_en");
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm  = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        ConsoleHelper.writeMessage(res.getString("specify.amount"));
        while(true) {
            try {
                String sum = ConsoleHelper.readString();
                Integer expectedAmount = Integer.parseInt(sum);
                if(expectedAmount <= 0) {
                    throw new NumberFormatException();
                }
                if(!cm.isAmountAvailable(expectedAmount)) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    continue;
                }
                Map<Integer, Integer> resultMap = cm.withdrawAmount(expectedAmount);
                for(Map.Entry<Integer, Integer> pair: resultMap.entrySet()) {
                    if(pair.getValue() != 0) {
                        ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
                    }
                }
                int result = 0;
                for(Map.Entry<Integer, Integer> pair: resultMap.entrySet()) {
                    result += pair.getKey() * pair.getValue();
                }
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), result, currencyCode));
                return;
            } catch(NumberFormatException | NullPointerException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } catch(NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        }
    }
}
