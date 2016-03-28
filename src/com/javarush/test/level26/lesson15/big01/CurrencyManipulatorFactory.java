package com.javarush.test.level26.lesson15.big01;

import java.util.*;

/**
 * Created by Аркадий on 26.01.2016.
 */
public class CurrencyManipulatorFactory {
    public static Map<String, CurrencyManipulator> storage = new HashMap<>();

    private CurrencyManipulatorFactory() {}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        for(Map.Entry<String, CurrencyManipulator> pair: storage.entrySet()) {
            if(currencyCode.equals(pair.getValue().getCurrencyCode())) {
                return pair.getValue();
            }
        }

        CurrencyManipulator resultManipulator = new CurrencyManipulator(currencyCode);
        storage.put(currencyCode, resultManipulator);
        return resultManipulator;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return storage.values();
    }
}
