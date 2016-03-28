package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream tempStream = new PrintStream(outputStream);
        System.setOut(tempStream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        String ad = "JavaRush - курсы Java онлайн";
        String[] array = result.split(System.lineSeparator());
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < array.length; i += 2)
        {
            list.add(array[i]);
            try
            {
                list.add(array[i + 1]);
                list.add(ad);
            }
            catch(IndexOutOfBoundsException e)
            {
                break;
            }
        }
        for(String s: list)
            System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
