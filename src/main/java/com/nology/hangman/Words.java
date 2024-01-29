package com.nology.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Words {

    private static final List<String> words = new ArrayList<>();

    static {
        words.add("structures");
        words.add("approximately");
        words.add("necessary");
        words.add("knowledge");
        words.add("tremendous");
        words.add("colleague");
        words.add("permission");
        words.add("hymn");
        words.add("participate");
        words.add("environment");
        words.add("mysterious");
        words.add("emergency");
        words.add("destination");
        words.add("families");
        words.add("receipt");
    }

    public String wordSelector(){
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

}
