package com.githubtools.githubtools.pingpong.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

public class ServerInitializer extends ChannelInitializer<NioSocketChannel> {

    @Override
    protected void initChannel(NioSocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new IdleStateHandler(5, 0, 0))
                .addLast(new HeartBeatDecoder())
                .addLast(new HeartBeatSimpleHandler());
    }
}
