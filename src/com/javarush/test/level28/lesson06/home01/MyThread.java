package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Аркадий on 08.02.2016.
 */
public class MyThread extends Thread {
    private static int priorityCounter = 1;

    public MyThread() {
        setPrior();
    }

    public MyThread(Runnable target) {
        super(target);
        setPrior();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPrior();
    }

    public MyThread(String name) {
        super(name);
        setPrior();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPrior();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPrior();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPrior();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPrior();
    }

    private void setPrior() {
        if(priorityCounter > 10) {
            priorityCounter = 1;
        }
        setPriority(priorityCounter++);
        int maxPriority = getThreadGroup().getMaxPriority();
        if(getPriority() > maxPriority) {
            setPriority(maxPriority);
        }
    }
}
