package com.ppx.collections;

import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapTest {
    @Test
    public void treemapTest() {
        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        for (int i = 0; i < 7; i++) {
            sortedMap.put(String.valueOf(i), 1);
        }

        SortedMap<String, Integer> sortedMap1 = sortedMap.tailMap("3");
        String s = sortedMap1.firstKey();
        System.out.println("");


    }
}
