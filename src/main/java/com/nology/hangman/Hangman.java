package com.nology.hangman;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Hangman {
    // THESE BECOME ENCAPSULATED INSTANCE VARIABLES
    // - THESE ARE STATE / DATA / CLASSES RELATED TO PLAYING A GAME OF HANGMAN
    private Interaction interaction;
    private Words words;
    private int lives;
    private List<Character> guesses;
    private int games;
    int userInput;
    boolean gameOver = false;

    public Hangman() {
        // CAN SET SOME OF THEM UP IN A CONSTRUCTOR
        interaction = new Interaction();
        guesses = new ArrayList<>();
        games = 0;
    }

    public void playHangman() {
        try {
            boolean gameOver = false;

            while (!gameOver) {
                // PARTS OF YOUR GAME CAN BE DIVIDED UP INTO PRIVATE METHODS THAT GET CALLED IN THIS METHOD
                gameStart();
                selectLevel();

                // START TO MOVE STAGES / LOGIC INTO METHODS.
                // - IT WILL BE TRICKY AT FIRST :S
            }
        } catch (InputMismatchException | NullPointerException e) {
            interaction.welcomeMessage();
        }
    }

    // ALL STARTING LOGIC
    private void gameStart() {
        interaction.welcomeMessage();
        int userInput = interaction.getUserInput();

        switch (userInput) {
            case 0:
                System.out.println("Thanks for playing");
                System.exit(0);
                break;
            case 1:
                // I HAVE MOVED THE interaction.chooseLevel();
                break;
            default:
                System.out.println("That is not a valid option.");
                gameStart();
                break;
        }
    }

    // ALL SELECT LEVEL LOGIC
    private void selectLevel() {
        interaction.chooseLevel();
        int userInput = interaction.getUserInput();

        if (userInput < 1 || userInput > 4) {
            System.out.println("Please enter a valid number.");
            selectLevel();
        }

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
        }
        playGame();
    }

    private void playGame() {
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


}
