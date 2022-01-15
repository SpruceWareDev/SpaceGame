package me.spruce.game.util;

import java.util.Random;

public class MathUtils {

    public static int getRandomInRange(int min, int max) {
        Random random = new Random();
        int range = max - min;
        int scaled = random.nextInt() * range;
        if (scaled > max) {
            scaled = max;
        }
        int shifted = scaled + min;

        if (shifted > max) {
            shifted = max;
        }
        return shifted;
    }
}
