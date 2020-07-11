package ru.job4j.tracker;

public class Item {
    private static int nextId = 1;
    private int id;
    private String name;
    public Item(){
        this.id = nextId++;
    };

    public Item(int id, String name) {
        this.name = name; this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return id + " " + name;
    }
}
