package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        boolean igrok_1 = true;
        boolean igrok_2 = false;
        Scanner inputPlayer1 = new Scanner(System.in);
        Scanner inputPlayer2 = new Scanner(System.in);
        while (true) {
            System.out.println("Player1 take matches from 1 to 3");


            int chois1 = Integer.valueOf(inputPlayer1.nextLine());
            System.out.println(" Igrok_1 zakonchil");
            matches = matches - chois1;
            System.out.println(matches + " matches left");
            System.out.println("Player2 take matches from 1 to 3");
            int chois2 = Integer.valueOf(inputPlayer2.nextLine());
            System.out.println("Igrok_2 zakonchil");
            matches = matches - chois2;
            System.out.println(matches + " matches left");

            if (matches ==0  & igrok_1) {
                System.out.println("Game Over! Igrok_1 pobedil");

                break;
            }
            else if(matches ==0 & igrok_2){
                System.out.println("Game over! Igrok_2 pobedil2");

                break;
            }

        }
    }
}
