package com.githubtools.githubtools.pingpong.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;


@Component
public class HeartBeatServer {
    private  NioEventLoopGroup boss = new NioEventLoopGroup();
    private  NioEventLoopGroup worker = new NioEventLoopGroup();

    @Value("${netty.server.port}")
    private int port;

    @PostConstruct
    public void start() throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ServerInitializer());

        ChannelFuture future = serverBootstrap.bind().sync();

        if (future.isSuccess()) {
            System.out.println("服务端启动成功");
        }



    }


}
