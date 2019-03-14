package com.githubtools.githubtools.pingpong.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.timeout.IdleStateHandler;

public class CustomerHandlerInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(new IdleStateHandler(0, 10, 0))
                .addLast(new HeartBeatEncode())
                .addLast(new EchoClintHandle());
    }
}
