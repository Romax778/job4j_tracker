package ru.job4j.professions;

public class Programmer extends Engineer {
    private String backendDeveloper;

    public Programmer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
        this.backendDeveloper = backendDeveloper;
    }

    public void ToCode() {
    }

}