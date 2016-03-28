package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Аркадий on 26.01.2016.
 */
public class CurrencyManipulator {
    public String currencyCode;
    public Map<Integer, Integer> denominations = new TreeMap<>(Collections.reverseOrder());

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if(denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int result = 0;
        for(Map.Entry<Integer, Integer> pair: denominations.entrySet()) {
            result += pair.getKey() * pair.getValue();
        }
        return result;
    }

    public boolean hasMoney() {
        return getTotalAmount() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount <= getTotalAmount();
    }

    //that withdrawAmount() method is good, but not for JR,
    // it's algorithm is better then at lower method
    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException{
        Map<Integer, Integer> resultMap = null;
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            list.add(pair.getKey());
        }
        boolean hasCombAlready = false;
        for (int i = 0; i < list.size(); i++) {
            Map<Integer, Integer> suitableDenominations = new TreeMap<>(Collections.reverseOrder());
            for (int j = i; j < list.size(); j++) {
                suitableDenominations.put(list.get(j), denominations.get(list.get(j)));
            }
            Map<Integer, Integer> tempMap;
            try {
                tempMap = getBanknotes(suitableDenominations, expectedAmount);
                hasCombAlready = true;
            } catch (NotEnoughMoneyException e) {
                if (hasCombAlready) {
                    continue;
                }
                throw e;
            }
            if (resultMap == null || hasMoreBanknotes(resultMap, tempMap) > 0) {
                resultMap = tempMap;
            } else if (hasMoreBanknotes(resultMap, tempMap) == 0) {
                ArrayList<Integer> resList = new ArrayList<>();
                ArrayList<Integer> tempList = new ArrayList<>();
                for (Map.Entry<Integer, Integer> pair : resultMap.entrySet()) {
                    resList.add(pair.getKey());
                }
                for (Map.Entry<Integer, Integer> pair : tempMap.entrySet()) {
                    tempList.add(pair.getKey());
                }
                for (int k = 0; k < Math.min(resList.size(), tempList.size()); k++) {
                    if (resList.get(k) < tempList.get(k)) {
                        resultMap = tempMap;
                    } else if (resList.get(k).equals(tempList.get(k))) {
                        Integer diff = resultMap.get(resList.get(k)) - tempMap.get(tempList.get(k));
                        if (diff < 0) {
                            resultMap = tempMap;
                        } else if (diff > 0) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        removeMoney(resultMap);
        return resultMap;
    }

    private static Map<Integer, Integer> getBanknotes(Map<Integer, Integer> denominations, int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> resultMap = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<Integer, Integer> pair: denominations.entrySet()) {
            int nominal = pair.getKey();
            int count = pair.getValue();
            int countNeed = expectedAmount / nominal;
            count = Math.min(count, countNeed);
            expectedAmount -= nominal * count;
            resultMap.put(nominal, count);
        }
        if(expectedAmount != 0) {
            throw new NotEnoughMoneyException();
        }
        return resultMap;
    }

    private static int hasMoreBanknotes(Map<Integer, Integer> resultMap, Map<Integer, Integer> tempMap) {
        int resCounter = 0;
        int tempCounter = 0;
        for(Map.Entry<Integer, Integer> pair: resultMap.entrySet()) {
            resCounter += pair.getValue();
        }
        for(Map.Entry<Integer, Integer> pair: tempMap.entrySet()) {
            tempCounter += pair.getValue();
        }
        return resCounter - tempCounter;
    }

    private void removeMoney(Map<Integer, Integer> map) {
        for(Map.Entry<Integer, Integer> pair: map.entrySet()) {
            denominations.put(pair.getKey(), denominations.get(pair.getKey()) - pair.getValue());
        }
    }


    /*
    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {   if(!isAmountAvailable(expectedAmount))throw new NotEnoughMoneyException();
        int summa = expectedAmount;
        TreeMap<Integer,Integer> result = new TreeMap<>(Collections.reverseOrder()); //создаём реверсивный TreeMap
        Map <Integer,Integer> temp = new HashMap<>();
        temp.putAll(denominations); // копируем все деньги в темповый HashMap

        greeglyAlgorithm(summa,temp,result); //применяем алгоритм

        denominations=temp;
        return result;
    }

    private void greeglyAlgorithm(int summa, Map<Integer,Integer> denom, Map<Integer,Integer> result) throws NotEnoughMoneyException
    {     Integer key=0;
        for (Map.Entry<Integer,Integer> pair : denom.entrySet()) //проходим по валютам и ищем максимально приближённую к сумме купюру
        {
            if (pair.getKey()<=summa&&pair.getKey()>key&&pair.getValue()>0){
                key=pair.getKey();
            }

        }

        if (result.containsKey(key))//найденую купюру добавляем в результат и вычитаем из темпового HashMap
        {  Integer j = result.get(key);
            result.put(key,j+1);
            j= denom.get(key);
            denom.put(key,j-1);
            summa-=key;
        }
        if (!result.containsKey(key)&&key!=0)//найденую купюру добавляем в результат и вычитаем из темпового HashMap
        {   result.put(key,1);
            Integer j = denom.get(key);
            denom.put(key,j-1);
            summa-=key;
        }


        if(summa!=0&&key!=0)greeglyAlgorithm(summa,denom,result);//если сумма не равна 0 и была добавленна на снятие купюра, то рекурсия

        if(summa!=0&&key==0)throw new NotEnoughMoneyException(); //если сумма не равна нулю и купюр не осталось, то кидаем исключение

    }
    */
}
