package com.testprogram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GenerateOutput {
    private String head = "";
    private String tail = "";
    private ArrayList<WordStore> testArray = new ArrayList<>();
    private ArrayList<String> dictionaryArray = new ArrayList<>();

    GenerateOutput() {
        Random random = new Random();
        int wordCount = 10 + random.nextInt(49990);

        System.out.println(wordCount);
        String lineIn = "";
        try {
            //File scan
            File fl = new File("Dictionary.txt");
            Scanner fileScan = new Scanner(fl);
            String[] words;//Temproary string storage for input.

            while (fileScan.hasNextLine()) {
                //Removes leading and trailing whitespace as it reads in each line.
                lineIn = fileScan.nextLine().trim();
                //adds file into dictionary array
                dictionaryArray.add(lineIn);
            }
            //Scrambling the dictionary array to generate an randomised list of words.
            Collections.shuffle(dictionaryArray);

            //grabbing a random number of words based on wordCount so that there is a lower bound of 10, and an upper bound of 50000.
            for (int i = 0; i < wordCount; i++) {
                int randVal = 1 + random.nextInt(10000);
                WordStore temp = new WordStore(dictionaryArray.get(i), randVal);
                testArray.add(temp);
            }

            //Sorts testArray so that the expected output is sorted by most to least then alphabetically if numbers are the same.
            Collections.sort(testArray, Collections.reverseOrder(new SortByCollections()));
            System.out.println("test array size: " + testArray.size());

            //Prints head(first ten words).
            System.out.println("Head:");
            for (int i = 0; i < 10; i++) {
                head += String.format("Word: %15s Count: %3d\n", testArray.get(i).getWord(), testArray.get(i).getCount());
                System.out.printf("Word: %15s Count: %3d\n", testArray.get(i).getWord(), testArray.get(i).getCount());
            }

            //Prints tail(last 10 words).
            System.out.println();
            System.out.println("Tail:");
            for (int i = wordCount - 10; i < wordCount; i++) {
                tail += String.format("Word: %15s Count: %3d\n", testArray.get(i).getWord(), testArray.get(i).getCount());
                System.out.printf("Word: %15s Count: %3d\n", testArray.get(i).getWord(), testArray.get(i).getCount());

            }
        }
        catch(IOException e)
        {
            System.out.println("Failed to read.");
        }
    }

    public String getHead() {
        return head;
    }

    public String getTail() {
        return tail;
    }

    public HashMap<String, Integer> getWordMap() {
        HashMap<String, Integer> wordMap = new HashMap<>();
        for(WordStore wordStore: testArray) {
            wordMap.put(wordStore.getWord(), wordStore.getCount());
        }
        return wordMap;
    }

    public String[] getWordArray() {
        String[] wordArray = new String[50000];
        for(int i = 0; i < testArray.size(); i++) {
            wordArray[i] = testArray.get(i).getWord();
        }
        return wordArray;
    }
}
