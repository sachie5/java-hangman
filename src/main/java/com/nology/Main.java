package com.nology;

import com.nology.hangman.Interaction;
import com.nology.hangman.Words;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {
    public static void main(String[] args) {

        Words words = new Words();
        Interaction interaction = new Interaction();
        final String chosenWord = words.wordSelector().toLowerCase();
        StringBuilder shownWord =  new StringBuilder(chosenWord.replaceAll("[a-zA-Z]", "_"));
        int lives = Interaction.getLives();
        List<Character> guesses = new ArrayList<>();

        interaction.welcomeMessage();

        int userInput = interaction.getIntegerInput();

        if (userInput == 0) {
            System.out.println("Thanks for playing");
            System.exit(0);
        } else if (userInput == 1) {
            System.out.println(shownWord);
            interaction.startGame();
        } else {
            System.out.println("That is not a valid option.");
            interaction.welcomeMessage();
        }


        while (shownWord.indexOf("_") != -1 && lives > 0){
            char userLetter = interaction.nextLetter();
            userLetter = Character.toLowerCase(userLetter);

            if(!guesses.contains(userLetter) && Character.isAlphabetic(userLetter)){
                guesses.add(userLetter);
                if (chosenWord.indexOf(userLetter) != -1) {
                    for (int i = 0; i < chosenWord.length(); i++) {
                        if(chosenWord.charAt(i) == userLetter) {
                            shownWord = shownWord.replace(i, i+1, String.valueOf((userLetter)));
                        }
                    }
                    System.out.println(shownWord);
                    System.out.println("Current lives: " + lives + ". Guesses: " + guesses);
                } else {
                    Interaction.reduceLives();
                    lives = Interaction.getLives();
                    System.out.println("Try again. Current lives: " + lives + ". Guesses: " + guesses);
                }
            } else if (guesses.contains(userLetter)){
                System.out.println("Please choose a letter that hasn't be previously chosen.");
            } else if (!Character.isAlphabetic(userLetter)){
                System.out.println("Please enter a letter in the alphabet.");
            }
        }

        if(shownWord.indexOf("_") == -1){
            System.out.println("Congratulations. You have won the game!");
            Interaction.endGame();
        } else if (lives == 0){
            System.out.println("Game over!");
            Interaction.endGame();
        }

        userInput = interaction.getIntegerInput();

        if(userInput == 3){
            System.exit(0);
        } else if(userInput == 4){
            Interaction.setLives();
            Interaction.startGame();
        } else {
            System.out.println("That is not a valid option.");
            Interaction.endGame();
        }
    }
}





