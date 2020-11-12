package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;


public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int position = 0;

    public Item add(Item item) {
        item.setId(ids++);

        return item;
    }

    public boolean replace(int id, Item item) {
        if (item == null) return false;
        items.add(id,item);
        return indexOf(item.getId())!=-1;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item>resList= new ArrayList<>();


        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(key)) {
              resList.add(items.get(i));
            }

        }

        return resList;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(id);
        }

        return index != -1
    }


    public Item findById(int id) {

        int index = indexOf(id);

        return index != -1 ? items.get(index) : null;
    }
}