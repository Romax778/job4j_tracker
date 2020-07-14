package ru.job4j.tracker;

import java.util.Arrays;


public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int position = 0;

    public Item add(Item item) {
        if(position >=100) return null;
        item.setId(ids++);
        items[position++] = item;
        return item;
    }

    public boolean replace(int id, Item item) {
        /*if (item == null) return false;*/

        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
        }
        return index != -1;
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

        return Arrays.copyOf(resArr, actualSize);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = null;
            System.arraycopy(items, index + 1, items, index, position - index);
            position--;
        }

        return index != -1;
    }


    public Item findById(int id) {

        int index = indexOf(id);

        return index != -1 ? items[index] : null;
    }
}