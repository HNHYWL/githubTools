package com.githubtools.githubtools.pingpong.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeartBeatConfig {

    //@Value("${channel.id}")
    private long id;


    public CustomerProtocol heartBeat() {
        return new CustomerProtocol(id, "ping");
    }

}
