package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Аркадий on 26.01.2016.
 */
public class Consumer implements Runnable {
    private final BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while(true) {
                System.out.println(queue.take());
            }
        } catch(InterruptedException ignore) {}
    }
}
