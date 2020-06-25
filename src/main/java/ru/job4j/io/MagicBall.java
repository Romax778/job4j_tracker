package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");

        String question = input.nextLine();


        int answer = new Random().nextInt(3);

            if (answer == 1) {
                System.out.println("Yes");

            }
             else if (answer == 2) {
                System.out.println("No");

            } else if(answer == 3){
                System.out.println("May be");

            }
        }

    }
