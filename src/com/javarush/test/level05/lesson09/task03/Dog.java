package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String name;
    private int height;
    private String colour;

    public Dog(String name)
    {
        this.name = name;
    }//Напишите тут ваш код

    public Dog(String name, int height)
    {
        this.name = name;
        this.height = height;
    }

    public Dog(String name, int height, String colour)
    {
        this.name = name;
        this.height = height;
        this.colour = colour;
    }
}
