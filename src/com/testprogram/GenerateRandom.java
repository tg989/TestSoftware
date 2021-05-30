package com.testprogram;

import java.util.Random;


public class GenerateRandom {
    public String randomString(int bounds) {
        int left = 97; // letter "a"
        int right = 122; // letter "z"
        Random random = new Random();

        String generatedString = random.ints(left, right+ 1)
                .limit(bounds)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public int randomNumber(int bounds) {
        Random rand = new Random();
        return rand.nextInt(bounds);
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
