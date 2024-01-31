# Hangman Project

In this project, we were required to create a hangman game using Java.

## Classes

The project consists of the following Classes:
** Interaction - where game commands and user interaction methods lie.
** Words - abstract class for words in the game.
** LevelOne - Level One Words that inherit from words.
** LevelTwo - Level Two Words that inherit from words.

## Key Functionality

This is how the word selected is stored and shown in underscores on the screen.
               
    final String chosenWord = words.wordSelector().toLowerCase();
    StringBuilder shownWord = new StringBuilder(chosenWord.replaceAll("[a-zA-Z]", "_"));
    System.out.println(shownWord);

This is how the letter is replaced if the userInput matches a letter in the word.

             if (chosenWord.indexOf(userLetter) != -1) {
               for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == userLetter) {
                    shownWord.replace(i, i + 1, String.valueOf((userLetter)));
                        }
                    }
