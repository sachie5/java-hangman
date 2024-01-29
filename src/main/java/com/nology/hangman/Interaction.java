package com.nology.hangman;

import java.util.Scanner;

public class Interaction {

    private Scanner scanner = new Scanner(System.in);
    private static final String[] commands = {"Enter 0 to end the game.", "Enter 1 to start the game.", "Guess a missing letter.", "Press 3 to Exit" , "Press 4 to start a new game."};
    private static int lives = 8;

    public static int getLives() {
        return lives;
    }

    public static void setLives() {
        lives = 8;
    }

    public static int reduceLives() {
        return lives--;
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Hangman. " + commands[0] + " " + commands[1]);
    }

    public static void startGame() {
        System.out.println(commands[2] + " Current lives: " + lives);
    }

    public int getIntegerInput() {
        return scanner.nextInt(commands.length);
    }

    public char nextLetter() {
        return scanner.next().charAt(0);
    }

    public static void endGame() {
        System.out.println(commands[3] + " " + commands[4]);
    }

}
