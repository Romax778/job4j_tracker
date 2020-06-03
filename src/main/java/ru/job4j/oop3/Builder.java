package ru.job4j.oop3;

import ru.job4j.oop3.Engineer;

public class Builder extends Engineer {
    private String foundation;

    public Builder(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
        this.foundation = foundation;
    }
    public String getFoundation(){
        return foundation;
    }

    public void toDig() {
    }
}