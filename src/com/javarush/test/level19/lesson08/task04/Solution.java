package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream tempStream = new PrintStream(outputStream);
        System.setOut(tempStream);
        testString.printSomething();
        String result = outputStream.toString();
        int space1 = result.indexOf(' ');
        int space2 = result.indexOf(' ', space1 + 1);
        int space3 = result.indexOf(' ', space2 + 1);
        int firstDig = Integer.parseInt(result.substring(0, space1));
        String sign = result.substring(space1 + 1, space2);
        int secondDig = Integer.parseInt(result.substring(space2 + 1, space3));
        int resDig = 0;
        switch(sign)
        {
            case("+"):
                resDig = firstDig + secondDig;
                break;
            case("-"):
                resDig = firstDig - secondDig;
                break;
            case("*"):
                resDig = firstDig * secondDig;
                break;
        }
        System.setOut(consoleStream);
        result = result.replaceAll("\r\n", "");
        result += resDig;
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

