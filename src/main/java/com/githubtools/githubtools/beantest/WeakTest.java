package com.githubtools.githubtools.beantest;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class WeakTest extends WeakReference<String> {

    public WeakTest(String referent) {
        super(referent);
    }

    public WeakTest(String referent, ReferenceQueue<? super String> q) {
        super(referent, q);
    }


    public static void main(String[] args) throws InterruptedException {

        WeakTest jdi = new WeakTest(new String("ji"));

        String s = jdi.get();
        System.out.println(s);
    }
}

class A {
    String s;

    public A(String s) {
        this.s = s;
    }
}

 class Test {
    public static void main(String[] args) throws Exception {

        String s = new String("123");
        // A a = new A(s);
        //
        // s = null;


        WeakReference<String> weak = new WeakReference<>(s);
        // s = null;
        System.out.println("value:" + weak.get());

        System.gc();

        System.out.println("value2:" + weak.get());

        PhantomReference<String> stringPhantomReference = new PhantomReference<String>(s, new ReferenceQueue<>());


    }
}


