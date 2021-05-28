package com.testprogram;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        assertTrue("Testing reading in the file without errors",testSubject.readFile());
    }

    // Test Spilt Words
    @Test
    public void testSpilt() {
        String line = randomGenerator.generateLine();
        String trimedLine = line.trim();
        String[] spiltWord = trimedLine.replaceAll("[\\p{P}]","").toLowerCase().split("\\W+");
        assertArrayEquals("Testing spilt words array", spiltWord, testSubject.spiltWords(line));
    }

    // Test unique checker
    @Test
    public void testUnique1() {
        String word = randomGenerator.randomString(15);
        assertTrue("Test if word is unique", testSubject.checkUnique(word));
    }

    @Test
    public void testUnique2() {
        String word = randomGenerator.randomString(15);
        testSubject.checkUnique(word);
        assertFalse("Test if word is not unique", testSubject.checkUnique(word));
    }

    // Test if word is empty
    @Test
    public void testWordEmpty1() {
        String word = "\n";
        assertFalse("Test if word is empty", testSubject.isNotEmptyWord(word));
    }

    @Test
    public void testWordEmpty2() {
        // PLACEHOLDER - String word = "Apples";
        String word = randomGenerator.randomString(15);
        assertTrue("Test if word is not empty", testSubject.isNotEmptyWord(word));
    }

    // Test word formatter
    @Test
    public void testFormatter() {
        // PLACEHOLDER - int i = 12;
        int count = randomGenerator.randomNumber(50000);
        String word = randomGenerator.randomString(15);
        String formatted = String.format("Word: %15s Count: %3d\n", word, count);
        assertEquals("Test if the output is formatted correctly", formatted, testSubject.formatOutput(word, count));
    }

    // Test head words output
    @Test
    public void testHeadOutput() {

        //String head = "Word: Apples Count: 1\n"; // PLACEHOLDER
        String head = randomOutput.getHead();
        assertEquals("Test if the head is correct", head, testSubject.printHead(randomOutput.getWordArray(), randomOutput.getWordMap()));
    }

    // Test tail words output
    @Test
    public void testTailOutput() {
        //String tail = "Word: Apples Count: 50000\n"; // PLACEHOLDER
        String tail = randomOutput.getTail();
        assertEquals("Test if the tail is correct", tail, testSubject.printTail(randomOutput.getWordArray(), randomOutput.getWordMap()));
    }

}
