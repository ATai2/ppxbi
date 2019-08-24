package com.ppx.message.ppxutil.hxp;

public class SeqSearch {
    public static void main(String[] args) {
        int arr[]={1,9,11,-1,34,89};
        System.out.println(seqSearch(arr,11));
    }

    /**
     *
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
