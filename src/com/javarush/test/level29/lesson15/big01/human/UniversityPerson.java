package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Аркадий on 08.03.2016.
 */
public class UniversityPerson extends Human {
    private University university;

    public UniversityPerson(String name, int age) {
        super(name, age);
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }
}
