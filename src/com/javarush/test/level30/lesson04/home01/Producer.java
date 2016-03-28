package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * Created by Аркадий on 09.03.2016.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 9; i++) {
                System.out.format("Элемент 'ShareItem-%d' добавлен\n", i);
                queue.put(new ShareItem("ShareItem-" + i, i));
                TimeUnit.MILLISECONDS.sleep(100);
                if (queue.hasWaitingConsumer()) {
                    System.out.println("Consumer в ожидании!");
                }
            }
        } catch (InterruptedException ignore) {}
    }
}
