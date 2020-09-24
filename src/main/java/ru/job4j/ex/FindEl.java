package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundExeption {
        int rsl = -1;
        for (int i = 0 ; i < value.length; i++) {
            if (value[i].equals(key)) {

                return i;
            }
        }throw new ElementNotFoundExeption("Element " + key + " Not found");
    }
    public static void main(String[]args)  {
        String[]arr = {"Kyiv","Riga","Lviv"};
        try {
            int res = indexOf(arr,"Lviv");
            System.out.println(res);
        } catch (ElementNotFoundExeption elementNotFoundExeption) {
            elementNotFoundExeption.printStackTrace();
        }
    }
}
