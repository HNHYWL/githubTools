package com.githubtools.githubtools.beantest;

import java.util.concurrent.TimeUnit;

public class JiOuNums {
    public static void main(String[] args) throws InterruptedException {
        Integer i = 0;
        Object lock = new Object();
        Integer[] a = new Integer[1];
        Integer[] b = new Integer[1];
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        String[] split = "kdj.dki".split(".");
        System.out.println(split.length);
        System.out.println(split[0]);


        new Thread(new Ji(i, lock)).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new Ou(i, lock)).start();



    }
}

class Ji implements Runnable{

    Integer i;

    Object lock;

    public Ji(Integer i, Object lock) {
        this.i = i;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (i % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println(i++ + "ji");
                    lock.notify();
                }
            }
        }
    }
}


class Ou implements Runnable{

    Integer i;
    Object lock;

    public Ou(Integer i, Object lock) {
        this.i = i;
        this.lock = lock;
    }

    public Ou(Integer i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (i % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println(i++ + "ou");
                    System.out.println(i);
                    lock.notify();
                }
            }
        }
    }
}
