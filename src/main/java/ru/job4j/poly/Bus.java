package ru.job4j.poly;

public class Bus implements Transport{
private int amount;
    @Override
    public void move() {
        System.out.println("Bus is moving");
    }

    @Override
    public void pickPassengers(int passengers) {
    amount += 3;

    }


    @Override
    public double fill(int litres) {

        return litres+=litres;
    }
}
