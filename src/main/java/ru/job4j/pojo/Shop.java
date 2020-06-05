package ru.job4j.pojo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Shop {
    public Product[]delete(Product[] products, int index) {
        for (int i = index; i < products.length-1; i++) {
            Product product = products[i];
            products[i] = products[i + 1];

        }
        products[products.length - 1] = null;
        return products;
    }


    public static void main(String[] args) {
Shop shop = new Shop();
        Product products[] = new Product[4];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = null;
        products[3] = new Product("Egg", 19);
products = shop.delete(products,2);
for (int i = 0; i < products.length ; i++){
    if(products[i]!=null){
        System.out.println(products[i].getName());
    }else{
        System.out.println("empty");
    }
}



    }
}
