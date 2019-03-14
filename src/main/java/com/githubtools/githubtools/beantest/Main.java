package com.githubtools.githubtools.beantest;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {



        Integer s = Integer.valueOf(3);
        Integer integer = Integer.valueOf(3);
        System.out.println(s == integer);

        Integer a = new Integer(3);
        Integer b = new Integer(3);
        Integer c = 3;
        int d = 3;
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(c == d);

        int[] aa = new int[0];
        System.out.println(Arrays.toString(aa));

        System.out.println(Arrays.toString(merge(new int[]{1,2,3,3,3,4,5}, new int[]{2,2,2,4,5})));

    }

    public static int[] merge(int a[], int b[]) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) return b;
        if (b == null) return a;
        int al = a.length;
        int bl = b.length;
        int[] c = new int[al + bl];

        int i = 0, j = 0;
        while (i < al || j < bl) {
            if (i == al) {
                c[i + j] = b[j++];
                continue;
            }
            if (j == bl) {
                c[i + j] = a[i++];
                continue;
            }

            if (a[i] <= b[j]) {
                c[j + i] = a[i++];
            } else {
                c[i + j] = b[j++];
            }
        }
        return c;


    }
}


class Ae {
    static {
        System.out.println(1);
    }

    public Ae() {
        System.out.println("a");
    }
}

class Be extends Ae {
static {
    System.out.println(2);
}

    public Be() {
        System.out.println("b");
    }
}

class CCCCC{

    public static boolean isPalindrome(int x) {

        int bak = x;
        if(x < 0) return false;
        long ans = 0;
        while (x != 0) {
            ans = ans*10 + x%10;
            x/=10;
        }

        return ans == bak;

    }

    public static void main(String[] args) {
        Ae a = new Be();
        a = new Be();


        boolean palindrome = isPalindrome(121);
        System.out.println(palindrome);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < len; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;

    }


    public int reverse(int x) {
        long ans = 0;

        int flag = 1;
        if (x < 0) {
            x = -x;
            flag = -1;
        }

        while (x != 0) {
            ans = ans * 10 + x%10;
            x/=10;
        }
        ans = ans * flag;
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)ans;
    }


}

