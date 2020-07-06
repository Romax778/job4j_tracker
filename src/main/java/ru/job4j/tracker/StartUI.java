package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item1 = new Item(1,"Max");
       Item item2 = new Item(2,"Petr");
       Item item3 = new Item(3,"Alex");
       Item item4 = new Item(4,"Valeriy");
       Item item5 = new Item(5,"Misha");

       tracker.add(item1);
       System.out.println(tracker.findById(1));
    }

    }

