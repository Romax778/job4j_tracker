package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String word = "Neizvestnoe slovo " + eng;
        return word;
    }

    public static void main(String[] args) {
        DummyDic peppy = new DummyDic();
        String say = peppy.engToRus("house");
        System.out.println( say);
    }
}
