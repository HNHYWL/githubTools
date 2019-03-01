package com.githubtools.githubtools.beantest;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.security.Key;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Intern {
    public static void main(String[] args) throws IOException {
        // String s = "{\"key\":0}";
        //
        // String k1 = "key";
        // InputStream inputStream = Intern.class.getResourceAsStream("test");
        // InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        // BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //
        // String line;
        // Integer i1 = new Integer(10);
        // while ((line = bufferedReader.readLine()) != null) {
        //     String key = line.trim().intern();
        //
        //     Integer i2 = Integer.valueOf(key);
        //     System.out.println(i1 == i2);
        //     System.out.println(i1.equals(i2));
        //
        //
        //     System.out.println(key);
        //     System.out.println(k1 == key);
        //     System.out.println(k1.equals(key));
        //
        //     // JSONObject json = JSON.parseObject(line);
        //     // Set<String> strings = json.keySet();
        //     // for (String key : strings) {
        //     //     System.out.println(key);
        //     //     System.out.println(k1 == key);
        //     //     System.out.println(k1.equals(key));
        //     // }
        // }

        String ss = "10\n" +
                "kjf\n" +
                "kjf\n" +
                "kjf\n" +
                "kjf\n" +
                "kjf\n" +
                "kjfjfuy\n" +
                "kjfjfuy\n" +
                "kjfjfuy\n" +
                "kjfjfuy\n" +
                "kjfjfuyndhfg\n" +
                "kjfjfuyndhfg\n" +
                "kjfjfuyndhfg\n" +
                "kjfjfuyndhfg\n" +
                "kjfjfuyndhfg\n" +
                "kjfjfuyndhfg\n" +
                "kjfjfuyndhfg\n" +
                "10\n" +
                "20\n" +
                "20";
        String[] split = ss.trim().split("\n");
        HashSet<String> strings = new HashSet<>();
        for (String key : split) {
            strings.add(key);
        }



        Map<String, Integer> count = new HashMap<>();
        for(String key: split){
            count.put(key, 0);
        }
        String line;

        BufferedReader reader = new BufferedReader(new FileReader("/Users/elf/IdeaProjects/githubTools/target/classes/com/githubtools/githubtools/beantest/test"));
        while((line = reader.readLine()) != null){
            if(count.containsKey(line)){
                count.put(line, count.get(line) + 1);
            }
        }

        TreeMap<Integer, List<String>> intList = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (!intList.containsKey(value)) {
                intList.put(value, new LinkedList<>());
            }
            intList.get(value).add(key);
        }

        for (Map.Entry<Integer, List<String>> entry : intList.entrySet()) {
            for (String key : entry.getValue()) {
                System.out.println(key + ": " + entry.getKey());
            }
        }


        KeyCount[] keyCounts = new KeyCount[count.size()];

        int i = 0;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            keyCounts[i++] = new KeyCount(entry.getKey(), entry.getValue());
        }


        Map.Entry<String, Integer>[] entries = new Map.Entry[count.size()];
        count.entrySet().toArray(entries);

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry + " :----------");
        }

        System.out.println("++++");
        quickSort(entries, 0, entries.length - 1);


        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry + " :----------");
        }




        for (KeyCount keyCount : keyCounts) {
            System.out.println(keyCount);
        }


        quickSort(keyCounts, 0, keyCounts.length - 1);
        System.out.println("====");

        for (KeyCount keyCount : keyCounts) {
            System.out.println(keyCount);
        }






    }


    public static void quickSort(Map.Entry<String, Integer>[] entries, int lowIndex, int highIndex) {
        if(lowIndex >= highIndex) return;

        int lowBak = lowIndex;
        int highBak = highIndex;

        Map.Entry<String, Integer> mid = entries[lowBak];
        while (lowIndex < highIndex) {
            while (mid.getValue() >= entries[highIndex].getValue() && lowIndex < highIndex) {
                highIndex--;
            }

            while (mid.getValue() < entries[lowIndex].getValue() && lowIndex < highIndex) {
                lowIndex++;
            }

            if (lowIndex < highIndex) {
                Map.Entry<String, Integer> tmp = entries[lowIndex];
                entries[lowIndex] = entries[highIndex];
                entries[highIndex] = tmp;
            }
        }
        quickSort(entries, lowBak, lowIndex);
        quickSort(entries, lowIndex+1 , highBak);

        new ConcurrentHashMap<>();
    }

    public static void quickSort(KeyCount[] keyCounts, int lowIndex, int highIndex) {
        if(lowIndex >= highIndex) return;
        int lowBak = lowIndex;
        int highBak = highIndex;
        KeyCount mid = keyCounts[lowIndex];

        while (lowIndex < highIndex) {
            while (mid.getCount() < keyCounts[lowIndex].getCount() && lowIndex < highIndex) {
                lowIndex++;
            }
            while (mid.getCount() >= keyCounts[highIndex].getCount() && lowIndex < highIndex) {
                highIndex--;
            }

            if (lowIndex < highIndex) {
                KeyCount tmp = keyCounts[lowIndex];
                keyCounts[lowIndex] = keyCounts[highIndex];
                keyCounts[highIndex] = tmp;
            }
        }
        System.out.println(lowIndex);
        quickSort(keyCounts, lowBak, lowIndex);
        quickSort(keyCounts, lowIndex+1, highBak);
    }

    // public static void quickSort(KeyCount[] keyCounts, int lowIndex, int highIndex) {
    //     if(lowIndex >= highIndex) return;
    //     int lowBak = lowIndex;
    //     int highBak = highIndex;
    //     KeyCount mid = keyCounts[lowIndex];
    //
    //     while (lowIndex < highIndex) {
    //         while (mid.getCount() >= keyCounts[lowIndex].getCount() && lowIndex < highIndex) {
    //             lowIndex++;
    //         }
    //         while (mid.getCount() < keyCounts[highIndex].getCount() && lowIndex < highIndex) {
    //             highIndex--;
    //         }
    //
    //         if (lowIndex < highIndex) {
    //             KeyCount tmp = keyCounts[lowIndex];
    //             keyCounts[lowIndex] = keyCounts[highIndex];
    //             keyCounts[highIndex] = tmp;
    //         }
    //     }
    //     quickSort(keyCounts, lowBak, lowIndex-1);
    //     quickSort(keyCounts, lowIndex, highBak);
    // }
}
