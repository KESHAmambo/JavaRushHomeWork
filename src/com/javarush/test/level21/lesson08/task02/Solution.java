package com.javarush.test.level21.lesson08.task02;

import java.util.Date;
import java.util.Random;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        clone = tree.clone();

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        public Tree clone()
        {
            String[] branches = null;
            if(this.branches != null)
            {
                branches = new String[this.branches.length];
                for (int i = 0; i < branches.length; i++)
                    branches[i] = this.branches[i];
            }
            return new Tree(getName(), branches);
        }
    }
}
