package com.ppx.common.message.ppxutil;

import java.util.Arrays;

public class SortUtils {

    private static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        print(arr);
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }

            }
        }
        print(arr);
    }

//    public static void bubbleSort2(int[] arr) {
//        print(arr);
//        int temp = 0;
//        boolean flag = false;
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if (arr[j] < arr[j - 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                    flag = true;
//                }
//
//            }
//        }
//        print(arr);
//    }

    public static void selectSort(int[] arr) {
        print(arr);

        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index=i;
            for (int j = i; j < arr.length ; j++) {
                if (min > arr[j ]) {
                    min = arr[j];
                    index=j;
                }
            }
            if (index != i) {
                int tm=arr[i];
                arr[i] = arr[index];
                arr[index]=min;
            }
        }
        print(arr);
    }

    public static void insertSort(int[] arr) {
        print(arr);
        int insertVal=0,insertIndex=0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex=i-1;
            while (insertIndex > 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {

            }
        }
    }

    public static void quickSort(int[] arr, int left, int right) {

    }
}
