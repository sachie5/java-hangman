package com.nology.hangman;

import java.util.Scanner;

public class Interaction {

    private static Scanner scanner = new Scanner(System.in);
    private static final String[] commands = {"Enter 0 to end the game.","Enter 1 to start the game.", "Guess a missing letter."};

    public static void welcomeMessage(){
        System.out.println("Welcome to Hangman. " + commands[0] + " " + commands[1]);
    }

    public static void startGame(){
        System.out.println(commands[2]);
    }

    public static int getIntegerInput(){
        return scanner.nextInt(commands.length);
    }


//    public static char getLetter(){
//        return scanner.
//    }
    public static String nextLetter(){
        return scanner.nextLine();
    }


}
