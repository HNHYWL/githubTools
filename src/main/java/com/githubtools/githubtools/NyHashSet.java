package com.githubtools.githubtools;

import java.util.HashSet;
import java.util.LinkedList;

public class NyHashSet {

    private int size = 5;
    private String[] strings = new String[size];

    public void add(String ele){
        int index = Math.abs(ele.hashCode())%size;
        strings[index] = ele;
    }

    public boolean isContain(String ele){
        int index = Math.abs(ele.hashCode())%size;
        if (strings[index] != null && strings[index].equals(ele)){
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        NyHashSet set = new NyHashSet();
        set.add("aaa");
        set.add("aaa");
        set.add("fdsdas");
        System.out.println(set);
        boolean fff = set.isContain("fff");
        System.out.println(fff);

    }
}
