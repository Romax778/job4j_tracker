package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;



    public void show() {
        System.out.println(this.food);
        System.out.println(this.name);
    }
    public void giveNick(String nick){
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        System.out.println("This cat's name .");
        gav.giveNick("Max");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.eat("fish");
        System.out.println("This cat's name .");
        black.giveNick("Tom");
        black.show();
    }
}
