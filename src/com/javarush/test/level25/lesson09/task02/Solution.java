package com.javarush.test.level25.lesson09.task02;

import java.util.Timer;
import java.util.TimerTask;

/* Вооружаемся до зубов!
Создайте свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскать звездочками имя трэда.
"Thread-0" должно быть заменено на "********"
"Thread-4321" должно быть заменено на "***********"
*/
public class Solution extends TimerTask {
    /*public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Solution(new TimerTask(){
            public void run() {
                int a = 1 / 0;
            }
        }), 1000);
    }*/

    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String name = t.getName();
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < name.length(); i++) {
                    sb.append('*');
                }
                System.out.println(e.getMessage().replace(name, sb.toString()));
            }
        };    //init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }
}