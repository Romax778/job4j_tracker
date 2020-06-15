package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
   private int position = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
    public Item[] findAll(){
  Item [] it  = new Item[position];
        System.arraycopy(items,0,it,0,position);
        return it;
    }
    public Item[] findByName(String key){
        Item[]resArr = new Item[position + 1];
        int temp = -1;
        for(int i = 0; i < position;i++){
            if(items[i].getName().equals(key)){
                resArr[++temp]= items[i];

            }


        }
        Item [] it2 = new Item[temp + 1];
        System.arraycopy(resArr,0,it2,0,it2.length);
        return it2;
    }
    public Item findById(String id) {
        Item rsl = null;
        for (int index = 0; index < position; index++) {
            Item item = items[index];
            if (item.getId().equals(id)) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}