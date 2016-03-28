package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Аркадий on 26.01.2016.
 */
public class Producer implements Runnable {
    private final ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        try {
            int i = 0;
            while (true) {
                map.put(String.valueOf(i++), "Some text for " + i);
                Thread.sleep(500);
            }
        } catch(InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
