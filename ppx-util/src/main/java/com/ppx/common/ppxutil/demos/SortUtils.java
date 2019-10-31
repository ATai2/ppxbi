package com.ppx.common.ppxutil.demos;

import java.util.Arrays;

public class SortUtils {

    public static void print(int[] arr) {
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
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                int tm = arr[i];
                arr[i] = arr[index];
                arr[index] = min;
            }
        }
        print(arr);
    }

    public static void insertSort(int[] arr) {
        print(arr);
        int insertVal = 0, insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left, r = right;
        if (l < r) {
            int pivot = arr[(left)];
            int index;
            while (l < r) {
                while (l < r && arr[r] >= pivot) {
                    r--;
                }
                arr[l] = arr[r];
                while (l < r && arr[l] <= pivot) {
                    l++;
                }
                arr[r] = arr[l];
            }
            arr[l] = pivot;
            index = l;
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    //    一半gap，减减加
    public static void shellSort(int[] arr) {
        print(arr);
        int temp = 0, count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        print(arr);
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid=(left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i=left;
        int j=mid+1;
        int t=0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t]=arr[i];
                t++;
                i++;
            }else{
                temp[t]=arr[j];
                t++;
                j++;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t]=arr[j];
            t++;
            j++;
        }
        t=0;
        int tempLeft=left;
        while (tempLeft <= right) {
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }

    public static void radixSort(int[] arr) {
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max=arr[i];
            }
        }
        int maxLength=(max+"").length();
        int[][] bucket=new int[10][arr.length];

        for (int i = 0; i < maxLength; i++) {

        }
    }



}
