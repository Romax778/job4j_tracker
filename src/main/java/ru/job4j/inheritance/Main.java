package ru.job4j.inheritance;

public class Main {
    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String text = report.generate("Tom", "Richard");
        System.out.println(text);
    }
}
