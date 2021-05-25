package com.sortthing;

import java.util.Random;

public class WordStore
{
    private String word;
    private int count;

    public WordStore(String word, int count)
    {
        this.word = word;
        this.count = count;

    }

    public String getWord()
    {
        return word;
    }
    public int getCount()
    {
        return count;
    }
    public void setCount(int number)
    {
        count = number;
    }

}
