/*
Assignment 1
Damien Edward Waters
Dew902
6119001
*/
package com.testprogram;
import java.io.*;
import java.util.Scanner;

public class Driver {
    private static final MergeSort mergeSort = new MergeSort();

    public String getFilePath() {
        //File Input
        System.out.println("Input file directory:");
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public boolean readFile() {
        try {
            //File scan
            File fl = new File(getFilePath());
            Scanner fileScan = new Scanner(fl);
            String[] words;//Temporary string storage for input.

            while(fileScan.hasNextLine())
            {
                words = spiltWords(fileScan.nextLine());
                //Runs a check for whether or not the words have been passed or not.
                for(String e:words)
                    checkUnique(e);
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

    public String printHead() {
        //Prints head(first ten words).
        System.out.println("Head:");
        String head = "";
        for(int i = 0; i<10;i++)
            head += formatOutput(i);
        System.out.println(head);
        return head;
    }

    public String formatOutput(int i) {
        return String.format("Word: %15s Count: %3d\n", mergeSort.getWordArray()[i], mergeSort.getWordMap().get( mergeSort.getWordArray()[i]));
    }

    public String printTail() {
        //Prints tail(last 10 words).
        //System.out.println();
        System.out.println("Tail:");
        String tail = "";
        for(int i = mergeSort.getIndex()-10; i< mergeSort.getIndex();i++)
            tail += formatOutput(i);
        System.out.println(tail);
        return tail;
    }

    public boolean checkUnique(String word) {
        boolean unique = false;
        //checks if the word entered is empty.
        if (isEmptyWord(word)) {
            /*Checks whether the word is already in the hashmap
            and if not it adds it to the array.*/
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

    public boolean isEmptyWord(String word) {
        return word.isEmpty() && word.trim().equals("") && word.trim().equals("\n");
    }
}
// c:\Uni\A1sample.txt
