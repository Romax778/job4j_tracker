package ru.job4j.tracker;

import java.util.Arrays;

public class Main {
    public static void main(String[]args){
        Tracker tracker = new Tracker();
        Item item1 = new Item("Petr");
        Item item2 = new Item("Petr");
        Item item3 = new Item("Alex");
        Item item4 = new Item("Valeriy");
        Item item5 = new Item("Misha");

        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);

        Item[]itemRes = tracker.findAll();
        System.out.println(itemRes.length);
        for(int i = 0; i< itemRes.length;i++){
            System.out.println(itemRes[i]);
        }

        Item found = tracker.findById(item4.getId());
        System.out.println(found);

        Item[]foundByName = tracker.findByName("Petr");
        System.out.println(Arrays.toString(foundByName));

        Item[]foundByName2 = tracker.findByName("Vasya");
        System.out.println((Arrays.toString(foundByName2)));
    }
}
