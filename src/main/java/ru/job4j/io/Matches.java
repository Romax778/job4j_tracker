package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        boolean run = true;
        Scanner inputPlayer1 = new Scanner(System.in);
        Scanner inputPlayer2 = new Scanner(System.in);
        while (true) {
            System.out.println("Player1 take matches from 1 to 3");


            int chois1 = Integer.valueOf(inputPlayer1.nextLine());
            matches = matches - chois1;
            System.out.println(matches + " matches left");
            System.out.println("Player2 take matches from 1 to 3");
            int chois2 = Integer.valueOf(inputPlayer2.nextLine());
            matches = matches - chois2;
            System.out.println(matches + " matches left");

            if (matches == 0) {
                System.out.println("Game Over");
                run = false;
                break;
            }
        }
    }
}
