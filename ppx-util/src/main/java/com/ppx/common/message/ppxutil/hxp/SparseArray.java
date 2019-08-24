package com.ppx.common.message.ppxutil.hxp;

public class SparseArray {
    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][2] = 2;

        for (int[] a :
                chessArr1) {
            for (int b :
                    a) {
                System.out.printf("%d \t",b);
            }
            System.out.println();
        }

        int sum=0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //set value for sparseArray
        int sparseArray[][]=new int[sum+1][3];


    }
}
