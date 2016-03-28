package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Аркадий on 04.11.2015.
 */
public class LoggingStateThread extends Thread
{
    private Thread trackedThread;
    private State currentState;
    public LoggingStateThread(Thread trackedThread)
    {
        this.trackedThread = trackedThread;
        setDaemon(true);
    }

    public void run()
    {
        while(true) {
            State state = trackedThread.getState();
            if(currentState != state) {
                currentState = state;
                System.out.println(state);
            }
            if(state == State.TERMINATED)
                break;
        }
    }
}
