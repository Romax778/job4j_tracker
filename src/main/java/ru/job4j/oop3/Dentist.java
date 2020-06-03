package ru.job4j.oop3;

import ru.job4j.oop3.Doctor;

public class Dentist extends Doctor {
private String drill;

    public Dentist(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
        this.drill = drill;
    }
    private void toFix(){}
}