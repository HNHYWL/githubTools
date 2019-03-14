package com.githubtools.githubtools.pingpong.client;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.channels.SocketChannel;

@Component
public class HeartBeatClient  {
    @Value("${netty.server.port}")
    private int port;

    @Value("${netty.server.host}")
    private String host;

    private NioEventLoopGroup group = new NioEventLoopGroup();

    private SocketChannel socketChannel;

    //@PostConstruct
    public void startClient() throws InterruptedException {
        Bootstrap boot = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new CustomerHandlerInitializer());

        ChannelFuture future = boot.connect(host, port).sync();
        if (future.isSuccess()) {
            System.out.println("启动netty成功");

        }

        socketChannel = (SocketChannel)future.channel();
    }
}
