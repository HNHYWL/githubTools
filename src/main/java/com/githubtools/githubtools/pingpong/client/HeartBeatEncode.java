package com.githubtools.githubtools.pingpong.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.concurrent.EventExecutorGroup;

public class HeartBeatEncode  extends MessageToByteEncoder<CustomerProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, CustomerProtocol msg, ByteBuf out) throws Exception {
        out.writeLong(msg.getId());
        out.writeBytes(msg.getType().getBytes());
    }
}
