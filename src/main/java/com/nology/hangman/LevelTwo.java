package com.nology.hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LevelTwo extends Words {
    private final String[] twoWords = {"absurd", "bookworm", "beekeeper", "microwave", "transplant", "oxygen", "whiskey",
            "youthful", "flapjack", "keyhole", "strength"};
    private final List<String> levelTwoList = Arrays.asList(twoWords);
    private final Random random = new Random();
    public void LevelTwoWords() {
       setWords();
    }

    @Override
    public String wordSelector() {
        return levelTwoList.get(random.nextInt(levelTwoList.size()));
    }
}
