package com.testprogram;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class GenerateRandom {
    public String randomString(int bounds) {
        byte[] array = new byte[bounds];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    public int randomNumber(int bounds) {
        Random rand = new Random(bounds);
        return rand.nextInt();
    }

    public String randomPath() {
        String path = "c:";
        int pathLength = randomNumber(10);
        for(int i = 0; i < pathLength; i++) {
            path += ("\\" + randomString(randomNumber(25)));
        }
        return path;
    }

    public String generateLine() {
        String line = "";
        int numberOfWords = randomNumber(20);
        for(int i = 0; i < numberOfWords; i++) {
            line += (" " + randomString(randomNumber(15)));
        }
        return line;
    }
}
