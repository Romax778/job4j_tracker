package ru.job4j.professions;

public class Doctor extends Profession {
    private String hospital;

    public Doctor(String name,String surname, String education, String birthday){
        super(name,surname,education,birthday);
        this.hospital = hospital;

    }
    public String getHospital(){
        return hospital;
    }
    private Treatment treat(Pacient pacient){
        Treatment treatment = new Treatment();
        return treatment;
    }
    private Diagnose mrt(Pacient pacient){
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }

}
