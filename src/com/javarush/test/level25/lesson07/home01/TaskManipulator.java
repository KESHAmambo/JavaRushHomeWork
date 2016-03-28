package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread current;
    @Override
    public void run() {
        //int i = 0;
        try {
            Thread.sleep(0);//эту строчку убрать, когда буду задавать вопрос, почему fifth выводится два раза
            while(!current.isInterrupted()) {
                //i++;
                System.out.println(current.getName());//System.out.println(threadName + " " + i);
                Thread.sleep(90);
            }
        }catch (InterruptedException ignored) {
            //System.out.println(threadName + " " + current.getName());
        }
    }

    @Override
    public void start(String threadName)
    {
        current = new Thread(this);
        current.setName(threadName);
        current.start();
    }

    @Override
    public void stop()
    {
        current.interrupt();
        //System.out.println("stop " + " " + current.getName() + ", isInterrupted: " + current.isInterrupted());
    }
}
