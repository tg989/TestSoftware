package com.testprogram;

import java.util.HashMap;

public class MergeSort {
    private int index = 0;//Tracks the total number of words entered
    private int unique = 0;//Tracks the total unique number of words
    private String[] wordArray = new String[50000];//Array for the keys.
    private HashMap<String, Integer> wordMap = new HashMap<>();//Hashmap to ensure words are unique.

    public String[] mergeSortWordArray() {
        return mSort(wordArray,0,index);
    }
    public String[] mSort(String[] temp,int left, int right)
    {
        if(left < right)
        {
            int centre = (left + right)/2;//Finds the mid-point.
            mSort(temp, left,centre);//Sorts the left side of the array
            mSort(temp, centre+1,right);//Sorts the right side of the array.
            merge(temp, left, right, centre);//merges the two sides of the array.
        }
        return temp;
    }
    public void merge(String[] temp,int l, int r,int c)
    {
        int leftHand = c - l + 1;//calculates the lefthand array's size.
        int rightHand = r - c;//calculates the righthand array's size.

        String left[] = new String[leftHand];//Initialises the lefthand array.
        String right[] = new String[rightHand];//Initialises the righthand Array.

        for(int count=0;count<leftHand;count++)//Populates the lefthand array
            left[count]= temp[l+count];

        for(int count=0;count<rightHand;count++)//Populates the righthand array
            right[count]= temp[c+1+count];

        int lpos=0,rpos=0,cpos=l;// Initialises relative indexes

        while((lpos < leftHand) && (rpos < rightHand))
        {
            int lmap = wordMap.get(left[lpos]);//These pass the count from the hashmap.
            int rmap = wordMap.get(right[rpos]);

            if(lmap > rmap )//Checks the count of the hashmap keys and places them appropriately according to the count.
            {
                temp[cpos]= left[lpos];
                lpos++;
                cpos++;
            }
            else if(lmap == rmap)//If values are equal this checks if they're in the right alphabetical order and places them accordingly.
            {
                if(left[lpos].compareTo(right[rpos]) < 0)
                {
                    temp[cpos]= left[lpos];
                    lpos++;
                    cpos++;
                }
                else
                {
                    temp[cpos]= right[rpos];
                    rpos++;
                    cpos++;
                }
            }
            else//The second half to the original check.
            {
                temp[cpos]= right[rpos];
                rpos++;
                cpos++;
            }
        }
        while(lpos < leftHand)//Places the leftover from the lefthand array.
        {
            temp[cpos]= left[lpos];
            lpos++;
            cpos++;
        }
        while(rpos < rightHand)//Places the leftover from the righthand array.
        {
            temp[cpos]=right[rpos];
            rpos++;
            cpos++;
        }
    }

    public void addToWordMap(String word, int count) {
        wordMap.put(word, count+1);
    }

    public void addToWordArray(String word) {
        wordArray[index] = word;
        index++;
    }

    public String[] getWordArray() {
        return wordArray;
    }

    public HashMap<String, Integer> getWordMap() {
        return wordMap;
    }

    public int getIndex() {
        return index;
    }

    public void decrementIndex() {
        index--;
    }

    public void incrementUnique() {
        unique++;
    }
}
