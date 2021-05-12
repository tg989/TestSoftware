package com.testprogram;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DriverTest {
    private Driver testSubject;

    @Before
    public void setUp() throws Exception {
        this.testSubject = new Driver();
    }

    @After
    public void tearDown() throws Exception {
        testSubject = null;
    }

    // Test file path input
    @Test
    public void testPath1() {
        String testFilePath = "c:\\Uni\\A1sample.txt";
        assertEquals("Testing true file path", testFilePath, testSubject.getFilePath());
    }

    // Test reading file contents

    // Test program timing
    // Test Spilt Words
    // Test unique checker
    // Test if word is empty
    // Test word formatter
    // Test head words output
    // Test tail words output
}
