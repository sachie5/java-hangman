package com.nology.hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class LevelOne extends Words {

    private final String[] oneWords = {"structures", "approximately", "necessary", "knowledge", "tremendous", "colleague", "permission",
            "hymn", "participate", "environment", "mysterious", "emergency", "destination", "families","receipt"};
    private final List<String> levelOneList = Arrays.asList(oneWords);
    private final Random random = new Random();
    public LevelOne() {
        setWords();
    }

    @Override
    public String wordSelector() {
        return levelOneList.get(random.nextInt(levelOneList.size()));
    }
}
