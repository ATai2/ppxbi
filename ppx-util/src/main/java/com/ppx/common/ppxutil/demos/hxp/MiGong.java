package com.ppx.common.ppxutil.demos.hxp;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        display(map);

        setWay(map, 1, 1);
        display(map);
    }

    private static void display(int[][] map) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("===========================");
        System.out.println();
    }

    /**
     * i,j position to start
     * 1 can't walk  2 pass 3 passed no
     *
     * @param map
     * @param i   begin
     * @param j
     * @return find way out true.
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;

                } else {
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}

