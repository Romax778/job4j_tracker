package ru.job4j.tracker;

import java.util.Arrays;


public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int position = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[position++] = item;
        return item;
    }



    public Item[] findAll() {

        return Arrays.copyOf(items, position);
    }

    public Item[] findByName(String key) {
        Item[] resArr = new Item[position];
        int actualSize = 0;

        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                resArr[actualSize++] = items[i];
            }

        }

        return Arrays.copyOf(resArr,actualSize);
    }

    public Item findById(int id) {
        Item result = null;

        for (int index = 0; index < position; index++) {
            Item current = items[index];

            if (current.getId()==id) {
                result = current;
                break;
            }
        }
        return result;
    }
}