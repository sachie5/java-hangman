package com.nology;

import com.nology.hangman.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ALL GAME LOGIC IS IN THE Hangman CLASS
        Hangman hangman = new Hangman();
        hangman.playHangman();
    }
}






