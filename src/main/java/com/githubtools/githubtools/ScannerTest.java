package com.githubtools.githubtools;

import com.githubtools.githubtools.consistenthash.Node;
import com.githubtools.githubtools.util.SpringBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class ScannerTest {

    public static void main(String[] args) {
        SpringApplication.run(ScannerTest.class, args);
        Scanner scanner = new Scanner(System.in);
        Node node0 = SpringBeanFactory.getBean(Node.class);



        while (true) {
            String line = scanner.nextLine();
            System.out.println(line);
            Node node = SpringBeanFactory.getBean(Node.class);
            System.out.println(""+node+node.hashCode()+(node == node0));

        }
    }
}
