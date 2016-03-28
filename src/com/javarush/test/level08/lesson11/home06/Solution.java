package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human child1 = new Human("Valera", true, 15);
        Human child2 = new Human("Sasha", true, 13);
        Human child3 = new Human("Lera", false, 10);
        ArrayList<Human> childrenList = new ArrayList<Human>();
        childrenList.add(child1);
        childrenList.add(child2);
        childrenList.add(child3);
        Human father = new Human("Petr", true, 37, childrenList);
        Human mother = new Human("Olga", false, 35, childrenList);
        ArrayList<Human> parentList1 = new ArrayList<Human>();
        parentList1.add(father);
        ArrayList<Human> parentList2 = new ArrayList<Human>();
        parentList2.add(mother);
        Human grandfather1 = new Human("Bob", true, 67, parentList1);
        Human grandmother1 = new Human("Masha", false, 66, parentList1);
        Human grandfather2 = new Human("Grisha", true, 63, parentList2);
        Human grandmother2 = new Human("Natasha", false, 61, parentList2);

        System.out.println(grandfather1.toString());
        System.out.println(grandmother1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());//Написать тут ваш код
    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }//Написать тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }
}
