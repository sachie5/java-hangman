package com.nology.hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LevelTwo extends Words {
    private final String[] twoWords = {"absurd", "bookworm", "beekeeper", "microwave", "transplant", "oxygen", "whiskey",
            "youthful", "flapjack", "keyhole", "strength"};
    private final List<String> levelTwoList = Arrays.asList(twoWords);
    public LevelTwo() {
       setWords();
    }

    @Override
    public String wordSelector() {
        Random random = new Random();
        return levelTwoList.get(random.nextInt(levelTwoList.size()));
    }
}
