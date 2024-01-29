package com.nology.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LevelOne extends Words {
    private final String[] oneWords = {"structures", "approximately", "necessary", "knowledge", "tremendous", "colleague", "permission",
            "hymn", "participate", "environment", "mysterious", "emergency", "destination", "families","receipt"};
    public LevelOne() {
        Words.setWords(Arrays.asList(oneWords));
    }
}
