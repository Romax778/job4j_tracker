package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();

        int matches = 11;
        boolean repeatGame = true;
        int playerNumber = rnd.nextInt(2) + 1; // 0...1 +1
        int userChoice;


        do {
            System.out.print("Player " + playerNumber + " take matches from 1 to 3 : ");
            do {
                userChoice = input.nextInt();
                if (userChoice < 1 || userChoice > 3 || userChoice > matches) {
                    System.out.println("Wrong amount of matches, try again!!!");
                } else {
                    break;
                }
            } while (true);

            matches -= userChoice;

            if (matches == 0) {
                System.out.println("Game Over! Player " + playerNumber + " win!!!");
                repeatGame = false;
            } else {
                System.out.println(matches + " matches left");
            }

            playerNumber = playerNumber == 1 ? 2 : 1;

        } while (repeatGame);
    }
}
