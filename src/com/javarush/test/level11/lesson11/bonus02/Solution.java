package com.javarush.test.level11.lesson11.bonus02;

/* Нужно добавить в программу новую функциональность
Добавь общий базовый класс к классам-фигур:  (фигуры из шахмат).
*/

public class Solution
{
    public static void main(String[] args)
    {
        ChessItem c = new King();
        King k = (King) c;

    }

    public static class ChessItem
    {
        public void Lal()
        {
            System.out.println("mozg");
        }
    }

    public static class King extends ChessItem
    {
        public void Lal()
        {
            System.out.println("brain");
        }
    }

    public class Queen extends ChessItem
    {
    }

    public class Rook extends ChessItem
    {
    }

    public class Knight extends ChessItem
    {
    }

    public class Bishop extends ChessItem
    {
    }

    public class Pawn extends ChessItem
    {
    }
}
