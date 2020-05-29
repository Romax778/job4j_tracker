package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Roman Abramovich");
        student.setCourse("Accounting");
        student.setStart(new Date());


        System.out.println( student.getName() + ", course  - " + student.getCourse());
    }
}
