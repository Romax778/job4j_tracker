package ru.job4j.professions;

import ru.job4j.professions.Profession;

public class Engineer extends Profession {

    private String activeProject;
    public  Engineer(String name,String surname, String education, String birthday){
        super(name, surname ,education ,birthday);
        this.activeProject = activeProject;
    }

    public String getActiveProject() {
        return activeProject;
    }



    public void  development(){}
}
