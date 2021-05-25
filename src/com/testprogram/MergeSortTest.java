package com.testprogram;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        stringOrderUpset(); //upset the order of the words array
        //in this case, should be 7 unique words in the String array
        Assert.assertEquals("Test unique", 7, testSubject.getUnique());
    }

    // Test merge sorted array
    @Test
    public void testCheckMergeSortedArray() {
        stringOrderUpset(); //upset the order of the words array
        String res[] = testSubject.mergeSortWordArray();
        //in this case, the right order in the String array should be
        Assert.assertEquals("Test 1st word of merge sorted array", expected[0], res[0]);
        Assert.assertEquals("Test 2nd word of merge sorted array", expected[1], res[1]);
        Assert.assertEquals("Test 3rd word of merge sorted array", expected[2], res[2]);
        Assert.assertEquals("Test 4th word of merge sorted array", expected[3], res[3]);
        Assert.assertEquals("Test 5th word of merge sorted array", expected[4], res[4]);
        Assert.assertEquals("Test 6th word of merge sorted array", expected[5], res[5]);
        Assert.assertEquals("Test 7th word of merge sorted array", expected[6], res[6]);
    }

    // Test merge sort
    @Test
    public void testMergeSort() {
        stringOrderUpset(); // upset the order of the words array
        String res[] = testSubject.mSort(words, 0, words.length-1);
        //in this case, the right order in the String array should be
        //Alice Beth Calvin Daisy David Erika Flora
        Assert.assertEquals("Test 1st word of merge sorted array", "David", res[0]);
        Assert.assertEquals("Test 2nd word of merge sorted array", "David", res[1]);
        Assert.assertEquals("Test 3rd word of merge sorted array", "Alice", res[2]);
        Assert.assertEquals("Test 4th word of merge sorted array", "Beth", res[3]);
        Assert.assertEquals("Test 5th word of merge sorted array", "Calvin", res[4]);
        Assert.assertEquals("Test 6th word of merge sorted array", "Daisy", res[5]);
        Assert.assertEquals("Test 7th word of merge sorted array", "Erika", res[6]);
        Assert.assertEquals("Test 7th word of merge sorted array", "Flora", res[7]);
    }

    // Test merge
    @Test
    public void testMerge() {
//        testSubject.merge(words, 1, 0, 0);
//        System.out.println(words[0]);
        //String words[]  = {"Erika","David","Flora","Beth","Alice","David","Calvin","Daisy"};
        //Assert.assertEquals("Test 7th word of merge sorted array","Flora" , testSubject.merge(words, 0, 0, 0));
    }

    /**
     * upset the order of the words array
     */
    private void stringOrderUpset() {
        for (int i = 0; i < words.length - 1; i++) {
            //get random word postion from the words array
            int random = (int) (Math.random() * (words.length - 1));
            //exchange two words
            String temp = words[i];
            words[i] = words[random];
            words[random] = temp;
        }
    }
}
