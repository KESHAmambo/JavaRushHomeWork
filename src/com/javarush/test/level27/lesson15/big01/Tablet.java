package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Аркадий on 31.01.2016.
 */
public class Tablet {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number)
    {
        this.number = number;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void createOrder() {
        Order order;
        try {
            //final Order order = new Order(this);
            order = new Order(this);
            create(order);
        } catch(IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    public void createTestOrder() {
        TestOrder order;
        try {
            order = new TestOrder(this);
            create(order);
        } catch(IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private void create(Order order) {
        if(!order.isEmpty()) {
            ConsoleHelper.writeMessage(order.toString());
            queue.add(order);
            //setChanged();
            //notifyObservers(order);
            try {
                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
            } catch(NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }

            /*
            new Thread() {
                @Override
                public void run() {
                    try {
                        new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
                    } catch(NoVideoAvailableException e) {
                        //StatisticEventManager.getInstance().register(
                        //        new NoAvailableVideoEventDataRow(order.getTotalCookingTime()* 60));
                        logger.log(Level.INFO, "No video is available for the order " + order);
                    }
                }
            }.start();
            */
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
