package com.githubtools.githubtools.consistenthash;


import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Component
@Data
public class Node implements Comparable<Node>{
    int hash;
    String ip;

    public Node() {

    }

    public Node(String ip) {
        this.hash = ip.hashCode();
        this.ip = ip;
    }

    public Node(int hash, String ip) {
        this.hash = hash;
        this.ip = ip;
    }

    @Override
    public int compareTo(Node o) {
        if (this.hash > o.hash) {
            return 1;
        } else  {
            return -1;
        }
    }
}


