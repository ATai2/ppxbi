package com.ppx.base;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortUtilsTest {
    int[] arr;

    @Before
    public void setUp() throws Exception {
        int size=8;
        arr=new int[size];
        for (int i = 0; i < size; i++) {
            arr[i]= (int) (Math.random()*size);
        }
    }

    @Test
    public void bubbleTest(){
        SortUtils.bubbleSort(arr);
    }@Test
    public void bubble2Test(){
//        SortUtils.bubbleSort2(arr);
    }
}