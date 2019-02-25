package com.githubtools.githubtools.beantest;


import org.springframework.stereotype.Component;

@Component
public class MyFirstBean {
    public void say() {
        System.out.println(this.getClass());
    }
}
