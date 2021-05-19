package com.testprogram;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {
    private Driver testSubject;
    private GenerateRandom randomGenerator;

    @Before
    public void setUp() throws Exception {
        this.testSubject = new Driver();
        this.randomGenerator = new GenerateRandom();
    }

    @After
    public void tearDown() throws Exception {
        testSubject = null;
        randomGenerator = null;
    }

    // Test file path input
    @Test
    public void testPath() {
        // Placeholder - String testFilePath = "c:\\Uni\\A1sample.txt";
        String testFilePath = randomGenerator.randomPath();
        assertEquals("Testing true file path", testFilePath, testSubject.getFilePath());
    }

    // Test reading file contents
    @Test
    public void testReadingFile() {
        assertTrue("Testing reading in the file without errors",testSubject.readFile());
    }

    // Test Spilt Words
    @Test
    public void testSpilt() {
        //PLACEHOLDER - String line = "Apples are Good";
        String line = randomGenerator.generateLine();
        // PLACEHOLDER - String[] spiltWord = {"apples", "are", "good"};
        String trimedLine = line.trim();
        String[] spiltWord = trimedLine.replaceAll("[\\p{P}]","").toLowerCase().split("\\W+");
        assertArrayEquals("Testing spilt words array", spiltWord, testSubject.spiltWords(line));
    }

    // Test unique checker
    @Test
    public void testUnique1() {
        // PLACEHOLDER - String word = "Apples";
        String word = randomGenerator.randomString(15);
        assertTrue("Test if word is unique", testSubject.checkUnique(word));
    }

    @Test
    public void testUnique2() {
        // PLACEHOLDER - String word = "Apples";
        String word = randomGenerator.randomString(15);
        testSubject.checkUnique(word);
        assertFalse("Test if word is not unique", testSubject.checkUnique(word));
    }

    // Test if word is empty
    @Test
    public void testWordEmpty1() {
        String word = ""; // PLACEHOLDER
        assertTrue("Test if word is empty", testSubject.isEmptyWord(word));
    }

    @Test
    public void testWordEmpty2() {
        // PLACEHOLDER - String word = "Apples";
        String word = randomGenerator.randomString(15);
        assertFalse("Test if word is not empty", testSubject.isEmptyWord(word));
    }

    // Test word formatter
    @Test
    public void testFormatter() {
        // PLACEHOLDER - int i = 12;
        int i = randomGenerator.randomNumber(50000);
        String formatted = String.format("Word: %15s Count: %3d\n", Driver.getMergeSort().getWordArray()[i], Driver.getMergeSort().getWordMap().get( Driver.getMergeSort().getWordArray()[i]));
        assertEquals("Test if the output is formatted correctly", formatted, testSubject.formatOutput(i));
    }

    // Test head words output
    @Test
    public void testHeadOutput() {
        String head = "Word: Apples Count: 1\n"; // PLACEHOLDER
        assertEquals("Test if the head is correct", head, testSubject.printHead());
    }

    // Test tail words output
    @Test
    public void testTailOutput() {
        String tail = "Word: Apples Count: 50000\n"; // PLACEHOLDER
        assertEquals("Test if the tail is correct", tail, testSubject.printTail());
    }

}
