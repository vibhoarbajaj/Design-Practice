package com.main.desgins.snakenladder.course.model;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class Dice {
    int diceCount;
    int min = 1;
    int max = 6;

    public int rollDice() {
        int totalSum = 0;
        int diceUsed = 0;
        while (diceUsed < diceCount) {
            diceUsed++;
            totalSum += ThreadLocalRandom.current().nextInt(min, max);
        }
        return totalSum;
    }
}
