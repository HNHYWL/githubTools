package com.githubtools.githubtools.pingpong.server;

import com.githubtools.githubtools.pingpong.client.CustomerProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.List;

public class HeartBeatDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        long id = in.readLong();
        byte[] bytes = new byte[in.readableBytes()];
        in.readBytes(bytes);
        String s = new String(bytes);

        CustomerProtocol customerProtocol = new CustomerProtocol(id, s);
        out.add(customerProtocol);
    }
}


