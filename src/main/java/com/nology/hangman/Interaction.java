package com.nology.hangman;

import java.util.Scanner;

public class Interaction {

    private Scanner scanner = new Scanner(System.in);
    private final String[] commands = {"Enter 0 to end the game.", "Enter 1 to start the game.", "Guess a missing letter.", "Press 3 to Exit" , "Press 4 to start a new game."};
    private int lives;
    public  int getLives() {
        return lives;
    }
    public void setLives() {
        this.lives = lives;
    }
    public  int reduceLives() {
        return lives--;
    }
    public void welcomeMessage() {
        System.out.println("Welcome to Hangman. " + commands[0] + " " + commands[1]);
    }
    public void chooseLevel(){
        System.out.println("Choose a level: 1, 2, 3 or 4");
    }
    public  void startGame() {
        System.out.println(commands[2] + " Current lives: " + lives);
    }
    public int amountOfLives(int lives){
        return this.lives = lives;
    }
    public int getUserInput() {
        return scanner.nextInt();
    }
    public char nextLetter() {
        return scanner.next().charAt(0);
    }
    public void endGame() {
        System.out.println(commands[3] + " " + commands[4]);
    }
    public void exitGame(){
        System.exit(0);
    }

}
