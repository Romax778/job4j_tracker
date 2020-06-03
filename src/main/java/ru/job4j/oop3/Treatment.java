package ru.job4j.oop3;

public class Treatment {

    public static class Surgeon extends Doctor {
        private String plasticSurgeon;
        public Surgeon(String name, String surname,String education, String birthday){
            super(name,surname,education,birthday);
            this.plasticSurgeon = plasticSurgeon;

        }
       public void toOperate(){

       }
    }
}
