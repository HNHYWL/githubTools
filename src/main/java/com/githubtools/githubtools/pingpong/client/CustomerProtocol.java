package com.githubtools.githubtools.pingpong.client;


import lombok.Data;

@Data
public class CustomerProtocol {
    private long id;
    private String type;

    public CustomerProtocol(long id, String type) {
        this.id = id;
        this.type = type;
    }
}
