package com.ppx.base.hxp;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, -2};

        int size = 8;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataStr = simpleDateFormat.format(date);
        System.out.println("fore sort " + dataStr);
        System.out.println(Arrays.toString(arr));

//        bublleSort(arr);
//        insertSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataStr2 = simpleDateFormat.format(date2);
        System.out.println("fore sort " + dataStr2);
    }

    private static void bublleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
//        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
//            if break the loop, find the index
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

//    希尔排序交换法
    private static void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("shell sort " + gap + "  " + Arrays.toString(arr));
        }
    }
//  希尔排序移位法
    static void shellSortPosition(int[] arr) {
        for (int gap = arr.length/2; gap >0; gap/=2) {
            for (int i = gap; i <arr.length ; i++) {
                int j=i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp<arr[j-gap]) {
                        arr[j] = arr[j - gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
        }
    }


    static void quikSort(int[] arr, int left, int right) {
//        left index
        int l=left;
//        right index
        int r=right;
        int pivot = arr[(left + right) / 2];
        int temp=0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r-=1;
            }
            if (l >= r) {
                break;
            } else {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
            if (arr[l] == pivot) {
                r-=1;
            }
            if (arr[r] == pivot) {
                l+=1;
            }
        }

        if (left < r) {
            quikSort(arr,left,r);
        }
        if (right > l) {
            quikSort(arr,l,right);
        }
    }





}
