package com.githubtools.githubtools.beantest;

import org.springframework.beans.factory.annotation.Autowired;

public class Bean2 {
    @Autowired
    MyFirstBean myFirstBean;

    public void say(String msg) {
        System.out.println(msg);
        myFirstBean.say();
    }
}
