package com.githubtools.githubtools.beantest;

import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class KeyCount {
    private int count;
    private String key;

    public KeyCount(String key, int count) {
        this.key = key;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "KeyCount{" +
                "count=" + count +
                ", key='" + key + '\'' +
                '}';
    }
}


/**
 * 盲人探路
 */
 class Move {

    public static void main(String[] args) {
        int[][] a = new int[7][21];
        a = install(a);
        for(int k=0; k<a.length; k++){
            for(int t=0;t<a[0].length;t++){
                System.out.print(a[k][t]+"  ");
            }
            System.out.println();
        }


        int[][] b = new int[4][5];
        show(b);
        generateB(b);
        show(b);


        int[] k = {1,1,2,2,3,3,4,4,5,6,6,7,8,9,10,10,11,12};
        Arrays.sort(k);
        int n = 1;
        int flag = k[k.length - 1];
        int j = k.length - 2;
        for (; j>-1;j--) {
            if(k[j] == flag) continue;
            n++;
            flag = k[j];
            if(n == 11) break;
        }
        System.out.println("11：" + flag + ", middle number: " + k[j/2]);


    }

    private static void show(int[][] b) {
        int r = b[0].length;
        int c = b.length;
        for (int i = 0; i < c; i++) {
            System.out.println(Arrays.toString(b[i]));
        }
    }

    private static void generateB(int[][] b) {
        int r = b[0].length;
        int c = b.length;
        int n = r * c;
        int k = 1;
        int i = 0;
        int j = 0;
        while (k <= n) {
            for (; j < r; j++) {
                if(b[i][j] != 0) break;
                b[i][j] = k++;
            }
            j--;
            i++;
            for (; i < c; i++) {
                if(b[i][j] != 0) break;
                b[i][j] = k++;
            }
            i--;
            j--;
            for (; j >= 0; j--) {
                if(b[i][j] != 0) break;
                b[i][j] = k++;
            }
            j++;
            i--;
            for (; i >= 0; i--) {
                if(b[i][j] != 0) break;
                b[i][j] = k++;
            }
            i++;
            j++;

            new ConcurrentHashMap<>();
            new HashMap<>();
        }
    }

    private static int[][] install(int[][] a){
        int i=0, j=0, direct = 0, count = 1;
        a[0][0] = count++;
        for(int x=0; x<a.length*a[0].length-1; x++) {
            if (detect(direct, a, i, j)) {
                direct = trunRight(direct);
            }
            int[] step = moved(direct, i, j);
            i = step[0];
            j = step[1];
            a[i][j] = count++;
        }
        return a;
    }
    private static int trunRight(int direct){
        return (direct + 1) % 4;
    }
    private static boolean detect(int direct, int[][] a, int i, int j){
        boolean balk = false;
        try {
            switch (direct) {
                case 0:
                    balk = a[i][++j] != 0; break;
                case 1:
                    balk = a[++i][j] != 0; break;
                case 2:
                    balk = a[i][--j] != 0; break;
                case 3:
                    balk = a[--i][j] != 0;
            }
        }catch (Exception e) {
            balk = true;
        }
        return balk;
    }
    private static int[] moved(int direct, int i, int j){
        switch (direct) {
            case 0: j++; break;
            case 1: i++; break;
            case 2: j--; break;
            case 3: i--;
        }
        return new int[]{i, j};
    }
}
