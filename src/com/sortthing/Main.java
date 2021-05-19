package com.sortthing;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        ArrayList<WordStore> testArray = new ArrayList<>();
        ArrayList<String> dictionaryArray = new ArrayList<>();
        Random random = new Random();
        int wordCount = 10 + random.nextInt(49990);

        System.out.println(wordCount);
        String lineIn = "";
        try
        {
            //File scan
            File fl = new File("Dictionary.txt");
            Scanner fileScan = new Scanner(fl);
            String[] words;//Temproary string storage for input.

            while(fileScan.hasNextLine())
            {
                //Removes leading and trailing whitespace as it reads in each line.
                lineIn = fileScan.nextLine().trim();
                //adds file into dictionary array
                dictionaryArray.add(lineIn);
            }
            //Scrambling the dictionary array to generate an randomised list of words.
            Collections.shuffle(dictionaryArray);

            //grabbing a random number of words based on wordCount so that there is a lower bound of 10, and an upper bound of 50000.
            for(int i = 0; i < wordCount;i++)
            {
                int randVal = 1 + random.nextInt(10000);
                WordStore temp = new WordStore(dictionaryArray.get(i),randVal);
                testArray.add(temp);
            }

            //Sorts testArray so that the expected output is sorted by most to least then alphabetically if numbers are the same.
            Collections.sort(testArray, Collections.reverseOrder(new SortByCollections()));
            System.out.println("test array size: "+ testArray.size());

            //Prints head(first ten words).
            System.out.println("Head:");
            for(int i = 0; i<10;i++)
                System.out.printf("Word: %20s Count: %3d\n", testArray.get(i).getWord(),testArray.get(i).getCount());


            //Prints tail(last 10 words).
            System.out.println();
            System.out.println("Tail:");
            for(int i = wordCount-10; i < wordCount; i++)
                System.out.printf("Word: %20s Count: %5d\n", testArray.get(i).getWord(),testArray.get(i).getCount());


        }
        catch(IOException e)
        {
            System.out.println("Failed to read.");
        }
    }


}
