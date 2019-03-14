package com.githubtools.githubtools.consistenthash;

import java.util.Arrays;

public class Hash {
    public static void main(String[] args) {
        Node[] nodes = {new Node(10, "ip1"), new Node(2, "ip2"), new Node(8, "ip3")};
        System.out.println(Arrays.toString(nodes));
        Arrays.sort(nodes);

        System.out.println(Arrays.toString(nodes));



        System.out.println(Arrays.binarySearch(nodes, new Node(1, "")));//1 3
        System.out.println(Arrays.binarySearch(nodes, new Node(3, "")));//2
        System.out.println(Arrays.binarySearch(nodes, new Node(2, "")));//2
        System.out.println(Arrays.binarySearch(nodes, new Node(8, "")));//2
        System.out.println(Arrays.binarySearch(nodes, new Node(11, "")));//1
    }
}


