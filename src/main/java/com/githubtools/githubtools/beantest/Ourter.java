package com.githubtools.githubtools.beantest;

public class Ourter {
    private Inner inner = new Inner();

    public void show() {
        inner.show();
    }

    public int show(int i) {
        return inner.show(i);
    }

    public static void main(String[] args) {
        String s = "a bc detg   ghi j k l mn op q";
        int len = 0, i = 0, j = 0;
        while (j < s.length()) {
            if (s.charAt(j) == ' ') {
                if((j - i) > len){
                    len = j - i;
                }
                while (j < s.length()) {
                    j++;
                    if (s.charAt(j) != ' ') {
                        i = j;
                        break;
                    }
                }
            }
            j++;
        }
        System.out.println(len);
    }
}
