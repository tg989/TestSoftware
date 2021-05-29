/*
Assignment 1
Damien Edward Waters
Dew902
6119001
*/
package com.testprogram;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {
    private static final MergeSort mergeSort = new MergeSort();

    public boolean readFile() {
        try {
            //File scan
            File fl = new File("A1sample.txt");
            Scanner fileScan = new Scanner(fl);
            String[] words;//Temporary string storage for input.

            while(fileScan.hasNextLine())
            {
                words = spiltWords(fileScan.nextLine());
                //Runs a check for whether or not the words have been passed or not.
                for(String e:words) {
                    checkUnique(e);
                }
            }
            mergeSort.decrementIndex();//index is incremented once too many, so this pulls it back appropriately.
            return true;
        } catch(IOException e) {
            System.out.println("Failed to read.");
            return false;
        }
    }

    public String[] spiltWords(String lineIn) {
        //Removes leading and trailing whitespace as it reads in each line.
        String line = lineIn.trim();
        //Removes punctuation, then converts characters to lowercase, and then finally splits each line on whitespaces.
        return line.replaceAll("[\\p{P}]","").toLowerCase().split("\\W+");

    }

    public String printHead(String[] array, HashMap<String, Integer> map) {
        //Prints head(first ten words).
        System.out.println("Head:");
        String head = "";
        for(int i = 0; i<10;i++)
            head += formatOutput(array[i], map.get(array[i]));
        System.out.println(head);
        return head;
    }

    public String formatOutput(String word, int count) {
        return String.format("Word: %15s Count: %3d\n", word, count);
    }

    public String printTail(String[] array, HashMap<String, Integer> map, int index) {
        //Prints tail(last 10 words).
        System.out.println("Tail:");
        String tail = "";
        for(int i = index - 10; i< index;i++)
            tail += formatOutput(array[i], map.get(array[i]));
        System.out.println(tail);
        return tail;
    }

    public boolean checkUnique(String word) {
        boolean unique = false;
        //checks if the word entered is empty.

        if (isNotEmptyWord(word)) {
            /*Checks whether the word is already in the hashmap
            and if not it adds it to the array.*/
            //System.out.println(word);
            if(!mergeSort.getWordMap().containsKey(word)) {
                unique = true;
                mergeSort.incrementUnique();
                mergeSort.addToWordArray(word);
            }
            /*Checks if the word is already in the hashmap.

            If the key  doesn't exist it adds it with a default count of 0,
            then increments the count by one.

            If the key already exists then it increments the count by 1.*/
            int count = mergeSort.getWordMap().getOrDefault(word, 0);
            mergeSort.addToWordMap(word, count);
        }
        return unique;
    }

    public boolean isNotEmptyWord(String word) {
        return word != null && !word.trim().isEmpty();
    }

    public static MergeSort getMergeSort() {
        return mergeSort;
    }
}
// c:\Uni\A1sample.txt
