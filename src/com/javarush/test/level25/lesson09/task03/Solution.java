package com.javarush.test.level25.lesson09.task03;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        getCauseMessage(e);
    }

    private static void getCauseMessage(Throwable e) {
        if(e.getCause() != null) {
            getCauseMessage(e.getCause());
        }
        System.out.println(e);
    }

    /*
    public static void main(String[] args) {
        Solution s = new Solution();
        s.uncaughtException(new Thread() {
            public void run() {}
        }, new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }*/
}
