package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man Alex = new Man("Alex", 25, "Moscow");
        Man Daniel = new Man("Daniel", 45, "Rostov");
        Woman Anastasia = new Woman("Anastasia", 34, "Magadan");
        Woman Maria = new Woman("Maria", 18, "Smolensk");

        System.out.println(Alex.name + " " + Alex.age + " " + Alex.address);
        System.out.println(Daniel.name + " " + Daniel.age + " " + Daniel.address);
        System.out.println(Anastasia.name + " " + Anastasia.age + " " + Anastasia.address);
        System.out.println(Maria.name + " " + Maria.age + " " + Maria.address);// Создай по два объекта каждого класса тут// Выведи их на экран тут
    }

    public static class Man
    {
        private String name;
        private int age;
        private String address;

        public Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman
    {
        private String name;
        private int age;
        private String address;

        public Woman(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }// Напиши тут свои классы
}
