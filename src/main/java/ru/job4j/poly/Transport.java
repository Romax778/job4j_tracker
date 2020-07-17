package ru.job4j.poly;

public interface Transport {
    void move();
    void pickPassengers(int passengers);
    double fill(int litres);
}
