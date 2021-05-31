package com.testprogram;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DriverTest {
    private Driver testSubject;
    private GenerateRandom randomGenerator;
    private GenerateOutput randomOutput;

    @Before
    public void setUp() throws Exception {
        this.testSubject = new Driver();
        this.randomGenerator = new GenerateRandom();
        this.randomOutput = new GenerateOutput();
    }

    @After
    public void tearDown() throws Exception {
        testSubject = null;
        randomGenerator = null;
        randomOutput = null;
    }

    // Test reading file contents
    @Test
    public void testReadingFile() {
        String message = "Testing reading in the file: ";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(message);
        boolean testReading = testSubject.readFile();
        System.out.println("Read in file: " + testReading);
        assertTrue(message, testReading);
    }

    // Test Spilt Words
    @Test
    public void testSpilt() {
        String message = "Testing split words array: ";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(message);
        String line = randomGenerator.generateLine();
        String trimedLine = line.trim();
        System.out.println("Generated Line: " + trimedLine);
        String[] splitWords = trimedLine.replaceAll("[\\p{P}]","").toLowerCase().split("\\W+");
        String[] actualSplitWords = testSubject.spiltWords(line);
        System.out.println("Expected split line: " + Arrays.toString(splitWords));
        System.out.println("Actual split line: " + Arrays.toString(actualSplitWords));
        assertArrayEquals(message, splitWords, actualSplitWords);
    }

    // Test unique checker
    @Test
    public void testUnique1() {
        String message = "Test if word is unique";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(message);
        String word = randomGenerator.randomString(15);
        System.out.println("Generated word: " + word);
        boolean checkUnique = testSubject.checkUnique(word);
        System.out.println("Is word unique: " + checkUnique);
        assertTrue(message, checkUnique);
    }

    @Test
    public void testUnique2() {
        String message = "Test if word is not unique";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(message);
        String word = randomGenerator.randomString(15);
        System.out.println("Generated word: " + word);
        testSubject.checkUnique(word);
        boolean checkUnique = testSubject.checkUnique(word);
        System.out.println("Is word unique: " + checkUnique);
        assertFalse(message, checkUnique);
    }

    // Test if word is empty
    @Test
    public void testWordEmpty1() {
        String message = "Test if word is empty";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(message);
        String word = "\n";
        System.out.println("Empty word: " + word);
        boolean checkEmpty = testSubject.isNotEmptyWord(word);
        System.out.println("Is not empty word: " + checkEmpty);
        assertFalse(message, checkEmpty);
    }

    @Test
    public void testWordEmpty2() {
        String message = "Test if word is not empty";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(message);
        String word = randomGenerator.randomString(15);
        System.out.println("Non-empty word: " + word);
        boolean checkEmpty = testSubject.isNotEmptyWord(word);
        System.out.println("Is not empty word: " + checkEmpty);
        assertTrue(message, checkEmpty);
    }

    // Test word formatter
    @Test
    public void testFormatter() {
        String message = "Test if the output is formatted correctly";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(message);
        int count = randomGenerator.randomNumber(50000);
        String word = randomGenerator.randomString(15);
        String formatted = String.format("Word: %15s Count: %3d\n", word, count);
        System.out.println("Expected formatted output: " + formatted);
        String actualFormatted = testSubject.formatOutput(word, count);
        System.out.println("Actual formatted output: " + actualFormatted);
        assertEquals(message, formatted, actualFormatted);
    }

    // Test head words output
    @Test
    public void testHeadOutput() {
        String message = "Test if the head is correct";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(message);
        String head = randomOutput.getHead();
        System.out.println("Expected Head: \n" + head);
        String actualHead = testSubject.printHead(randomOutput.getWordArray(), randomOutput.getWordMap());
        System.out.println("Actual Head: \n" + actualHead);
        assertEquals(message, head, actualHead);
    }

    // Test tail words output
    @Test
    public void testTailOutput() {
        String message = "Test if the tail is correct";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(message);
        String tail = randomOutput.getTail();
        System.out.println("Expected tail: \n" + tail);
        int count = randomOutput.getWordCount();
        String actualTail = testSubject.printTail(randomOutput.getWordArray(), randomOutput.getWordMap(), count);
        System.out.println("Actual Tail: \n" + actualTail);
        assertEquals(message, tail, actualTail);
    }

}
