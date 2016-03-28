package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null)
            throw new TooShortStringException();

        int firstIndex = string.indexOf(" ") + 1;
        if(firstIndex == 0)
            throw new TooShortStringException();

        int secondIndex = firstIndex;
        for(int i = 0; i < 3; i++)
        {
            secondIndex = string.indexOf(" ", secondIndex) + 1;
            if(secondIndex == 0)
                throw new TooShortStringException();
        }

        while(true) {
            try {
                if(string.charAt(secondIndex) != ' ') {
                    int temp = secondIndex;
                    secondIndex = string.indexOf(" ", secondIndex);
                    if(secondIndex == -1) {
                        try{
                            string.charAt(temp + 1);
                            return string.substring(firstIndex);
                        } catch(StringIndexOutOfBoundsException e) {
                            throw new TooShortStringException();
                        }
                    }
                    return string.substring(firstIndex, secondIndex);
                }
                else
                    secondIndex++;
            } catch(StringIndexOutOfBoundsException e) {
                throw new TooShortStringException();
            }
        }
    }

    public static class TooShortStringException extends Exception {
    }
}
