package com.testprogram;

import java.util.Comparator;

public class SortByCollections implements Comparator<WordStore>
{
    public int compare(WordStore a, WordStore b)
    {
        int result = Integer.valueOf(a.getCount()).compareTo(b.getCount());
        if(result==0)
        {
            return b.getWord().compareToIgnoreCase(a.getWord());
        }
        else
        {
            return result;
        }
    }
}
