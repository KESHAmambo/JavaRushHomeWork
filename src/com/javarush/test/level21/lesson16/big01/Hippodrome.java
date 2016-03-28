package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Аркадий on 13.09.2015.
 */
public class Hippodrome
{
    static private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void move()
    {
        for(Horse h: horses)
            h.move();
    }

    public void print()
    {
        for(Horse h: horses)
            h.print();
        System.out.println();
        System.out.println();
    }

    public void run()
    {
        for(int i = 0; i < 100; i++)
        {
            move();
            print();
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner()
    {
        Horse winner = horses.get(0);
        for(Horse h: horses)
            if(h.getDistance() > winner.getDistance())
                winner = h;
        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args)
    {
        game = new Hippodrome();
        game.horses.add(new Horse("Fast", 3, 0));
        game.horses.add(new Horse("Normal", 3, 0));
        game.horses.add(new Horse("Slowly", 3, 0));
        game.run();
        game.printWinner();
    }
}
