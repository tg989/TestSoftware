package com.testprogram;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {

    private MergeSort testSubject;
    private String[] words = {"Alice", "Erika", "David", "Flora", "Beth", "David", "Calvin", "Daisy"}; //Test words array.;
    private String[] expected ={"David", "Alice", "Beth", "Calvin", "Daisy", "Erika", "Flora"};// expected words order

    @Before
    public void setUp() throws Exception {
        this.testSubject = new MergeSort();
    }

    //initialization
    @Before
    public void init() throws Exception {
        //words = generateRandomString(10);
        for (String word : words) {
            /*Checks whether the word is already in the hashmap
            and if not it adds it to the array.*/
            if (!testSubject.getWordMap().containsKey(word)) {
                testSubject.incrementUnique();
                testSubject.addToWordArray(word);
            }
            int count = testSubject.getWordMap().getOrDefault(word, 0);
            testSubject.addToWordMap(word, count);
        }
        testSubject.decrementIndex();
    }

    @After
    public void tearDown() throws Exception {
        testSubject = null;
    }

    // Test check unique
    @Test
    public void testCheckUnique() {
        String message = "Test amount of unique words";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(message);
        stringOrderUpset(); //upset the order of the words array
        //in this case, should be 7 unique words in the String array
        System.out.println("Expected amount: " + 7);
        int actualAmount = testSubject.getUnique();
        System.out.println("Actual amount: " + actualAmount);
        Assert.assertEquals(message, 7, actualAmount);
    }

    // Test merge sorted array
    @Test
    public void testCheckMergeSortedArray() {
        String message = "Test if merge sorted array";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(message);
        stringOrderUpset(); //upset the order of the words array
        String res[] = testSubject.mergeSortWordArray();
        //in this case, the right order in the String array should be
        System.out.println("Expected Array: " + Arrays.toString(expected));
        System.out.println("Actual Array: " + Arrays.toString(res));
        Assert.assertArrayEquals(expected, res);
    }

    // Test merge sort
    @Test
    public void testMergeSort() {
        String message = "Test if merged correctly in array: ";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(message);
        stringOrderUpset(); // upset the order of the words array
        String res[] = testSubject.mSort(words, 0, words.length-1);
        //in this case, the right order in the String array should be [Alice Beth Calvin Daisy David Erika Flora]
        System.out.println("Expected Array: [David, David, Alice, Beth, Calvin, Daisy, Erika, Flora]");
        System.out.println("Actual Array: " + Arrays.toString(res));
        Assert.assertEquals("Test 1st word of merge sorted array", "David", res[0]);
        Assert.assertEquals("Test 2nd word of merge sorted array", "David", res[1]);
        Assert.assertEquals("Test 3rd word of merge sorted array", "Alice", res[2]);
        Assert.assertEquals("Test 4th word of merge sorted array", "Beth", res[3]);
        Assert.assertEquals("Test 5th word of merge sorted array", "Calvin", res[4]);
        Assert.assertEquals("Test 6th word of merge sorted array", "Daisy", res[5]);
        Assert.assertEquals("Test 7th word of merge sorted array", "Erika", res[6]);
        Assert.assertEquals("Test 7th word of merge sorted array", "Flora", res[7]);
    }

    /**
     * upset the order of the words array
     */
    private void stringOrderUpset() {
        for (int i = 0; i < words.length - 1; i++) {
            //get random word position from the words array
            int random = (int) (Math.random() * (words.length - 1));
            //exchange two words
            String temp = words[i];
            words[i] = words[random];
            words[random] = temp;
        }
    }
}
