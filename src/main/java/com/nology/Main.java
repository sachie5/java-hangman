package com.nology;

import com.nology.hangman.Interaction;
import com.nology.hangman.Words;


import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Words words = new Words();
        Interaction interaction = new Interaction();
        final String chosenWord = words.wordSelector();
        String shownWord = chosenWord;

        interaction.welcomeMessage();

        int userInput = interaction.getIntegerInput();

        if (userInput == 0) {
            System.out.println("Thanks for playing");
            System.exit(0);
        } else if (userInput == 1) {
            shownWord = shownWord.replaceAll("[a-zA-Z]", "_ ");
            System.out.println(shownWord);
            interaction.startGame();
            interaction.nextLetter();
        } else {
            System.out.println("That is not a valid option.");
        }

        while (shownWord.contains("_")) {
            String userLetter = interaction.nextLetter();
            char userChar = userLetter.charAt(0);
            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == userChar) {
                    shownWord = shownWord.substring(0, i) + userChar + shownWord.substring(i + 1);
                    System.out.println(shownWord);
                } else {
                    System.out.println("Try again.");
                }
            }

        }
    }
}





