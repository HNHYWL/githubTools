package com.githubtools.githubtools.guaua;


import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import jdk.nashorn.internal.runtime.options.Option;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Optional<Integer> a = Optional.of(8);
        if (a.isPresent()) {
            System.out.println(a.get());
        }
        System.out.println(a);
        a = Optional.fromNullable(null);
        System.out.println(a);

        if (a.isPresent()) {
            System.out.println(a.get());
        }
        // System.out.println(a.get());

        ImmutableList<String> of = ImmutableList.of("a", "b");
        System.out.println(of);

        ImmutableMap<String, ? extends Serializable> of1 = ImmutableMap.of("kei", 2, "jid", "kid");
        System.out.println(of1);


        ArrayBlockingQueue<Runnable> runnables = new ArrayBlockingQueue<Runnable>(10);


        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread().getName());
                        }
                    };
                    runnables.add(runnable);
                }
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                while (true) {
                    Runnable task = runnables.poll();
                    if (task != null) {
                        task.run();
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();





    }
}
