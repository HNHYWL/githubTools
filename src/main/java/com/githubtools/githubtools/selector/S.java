package com.githubtools.githubtools.selector;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class S {
    public static void main(String[] args) throws IOException {
        AbstractSelector abstractSelector = SelectorProvider.provider().openSelector();
        System.out.println(abstractSelector.getClass());

        Selector open = Selector.open();
        System.out.println(open.getClass());

        Integer[] integers = new Integer[90];
        integers[0] = 90;
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, integers);
        System.out.println(set.size());
        Set<Integer> set1 = Collections.unmodifiableSet(set);
        set1.add(8);
        System.out.println(set1.size());
    }
}
