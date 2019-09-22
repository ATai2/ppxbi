package com.ppx.common.ppxutil.demos.hxp;

import java.util.Arrays;

public class SelectSort {
    public static void main2(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};

        selectSort(arr);

    }

    private static void selectSort(int[] arr) {
        System.out.println("before fort");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            int minIndex = 0;
            int min = arr[0];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println("after sort");
        System.out.println(Arrays.toString(arr));
    }
}
