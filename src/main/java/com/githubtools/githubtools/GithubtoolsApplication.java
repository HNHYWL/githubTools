package com.githubtools.githubtools;

import com.githubtools.githubtools.beantest.Bean2;
import com.githubtools.githubtools.beantest.MyFirstBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GithubtoolsApplication {
    @Autowired
    public static MyFirstBean myFirstBean;



    public static void main(String[] args) {
        SpringApplication.run(GithubtoolsApplication.class, args);

    }

}
