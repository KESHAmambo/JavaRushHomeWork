package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public static class Human
    {
        private String name;
        private int age;
        private boolean sex;
        private double weight;
        private double height;
        private Object pet;

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human(boolean sex)
        {
            this.sex = sex;
        }

        public Human(double weight)
        {
            this.weight = weight;
        }

        public Human(Object pet)
        {
            this.pet = pet;
        }

        public Human(int age)
        {
            this.age = age;
        }

        public Human(int age, String name)
        {
            this.age = age;
            this.name = name;
        }

        public Human(boolean sex, double weight)
        {
            this.sex = sex;
            this.weight = weight;
        }

        public Human(double weight, double height)
        {
            this.weight = weight;
            this.height = height;
        }

        public Human(boolean sex, Object pet)
        {
            this.sex = sex;
            this.pet = pet;
        }//напишите тут ваши переменные и конструкторы
    }
}
