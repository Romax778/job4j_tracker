package ru.job4j.oop;

public class Predator extends Animal {
    public  Predator(){
        super();
        System.out.println("Load predator");
    }
    public Predator(String name){
        super(name);
    }
}
