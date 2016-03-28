package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for(Student student: students) {
            if(student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student bestStudent = students.get(0);
        for(Student student: students) {
            if(student.getAverageGrade() > bestStudent.getAverageGrade()) {
                bestStudent = student;
            }
        }
        return bestStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        Student worstStudent = students.get(0);
        for(Student student: students) {
            if(student.getAverageGrade() < worstStudent.getAverageGrade()) {
                worstStudent = student;
            }
        }
        return worstStudent;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}
