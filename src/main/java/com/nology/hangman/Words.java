package com.nology.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Words {

    private static List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public static void setWords(List<String> words) {
        Words.words = words;
    }

    public String wordSelector(){
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }


}
