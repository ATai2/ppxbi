package com.ppx.common.ppxutil.demos;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortUtilsTest {

    int[] arr;
    @Before
    public void setUp() throws Exception {
        arr=new int[]{3,7,4,9,1,4,8};
    }

    @Test
    public void bubbleSort() {
    }

    @Test
    public void selectSort() {
    }

    @Test
    public void insertSort() {
        SortUtils.insertSort(arr);
        SortUtils.print(arr);
    }

    @Test
    public void quickSort() {
        SortUtils.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void shellSort() {
        SortUtils.shellSort(arr);
    }
}