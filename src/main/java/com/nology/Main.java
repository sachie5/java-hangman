package com.nology;

import com.nology.hangman.Interaction;
import com.nology.hangman.LevelOne;
import com.nology.hangman.LevelTwo;
import com.nology.hangman.Words;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Words words = null;
        Interaction interaction = new Interaction();
        int lives = interaction.getLives();
        List<Character> guesses = new ArrayList<>();
        int userInput;
        boolean gameOver = false;
        int games = 0;

        try {
            while(!gameOver) {
                interaction.welcomeMessage();
                userInput = interaction.getUserInput();

                    switch (userInput) {
                        case 0:
                        System.out.println("Thanks for playing");
                        System.exit(0);
                        break;
                        case 1:
                        interaction.chooseLevel();
                        break;
                        default:
                        System.out.println("That is not a valid option.");
                        break;
                    }

                userInput = interaction.getUserInput();

                if (userInput == 1) {
                    words = new LevelOne();
                    lives = interaction.amountOfLives(8);
                } else if (userInput == 2) {
                    words = new LevelOne();
                    lives = interaction.amountOfLives(5);
                } else if (userInput == 3) {
                    words = new LevelTwo();
                    lives = interaction.amountOfLives(8);
                } else if (userInput == 4) {
                    words = new LevelTwo();
                    lives = interaction.amountOfLives(5);
                } else {
                    System.out.println("Please enter a valid number.");
                }

                final String chosenWord = words.wordSelector().toLowerCase();
                StringBuilder shownWord = new StringBuilder(chosenWord.replaceAll("[a-zA-Z]", "_"));
                System.out.println(shownWord);
                interaction.startGame();

                while (shownWord.indexOf("_") != -1 && lives > 0) {
                    char userLetter = interaction.nextLetter();
                    userLetter = Character.toLowerCase(userLetter);

                    if (!guesses.contains(userLetter) && Character.isAlphabetic(userLetter)) {
                        guesses.add(userLetter);
                        if (chosenWord.indexOf(userLetter) != -1) {
                            for (int i = 0; i < chosenWord.length(); i++) {
                                if (chosenWord.charAt(i) == userLetter) {
                                    shownWord.replace(i, i + 1, String.valueOf((userLetter)));
                                }
                            }
                            System.out.println(shownWord);
                            System.out.println("Current lives: " + lives + ". Guesses: " + guesses);
                        } else {
                            lives = interaction.reduceLives();
                            System.out.println(shownWord);
                            System.out.println("Try again. Current lives: " + lives + ". Guesses: " + guesses);
                        }
                    } else if (guesses.contains(userLetter)) {
                        System.out.println("Please choose a letter that hasn't be previously chosen.");
                    } else if (!Character.isAlphabetic(userLetter)) {
                        System.out.println("Please enter a letter in the alphabet.");
                    }
                }

                if (shownWord.indexOf("_") == -1) {
                    System.out.println("Congratulations. You have won the game!");
                    games++;
                    gameOver = true;
                    interaction.endGame();
                } else if (lives == 0) {
                    System.out.println("Game over!");
                    games++;
                    gameOver = true;
                    interaction.endGame();
                }

                if (gameOver) {
                    userInput = interaction.getUserInput();
                    if (userInput == 3) {
                        interaction.exitGame();
                    } else if (userInput == 4) {
                        interaction.setLives();
                        guesses.clear();
                        gameOver = false;
                    } else {
                        System.out.println("That is not a valid option.");
                        interaction.endGame();
                    }
                }
            }
        } catch (InputMismatchException | NullPointerException e) {
            interaction.welcomeMessage();
        }
    }
}






