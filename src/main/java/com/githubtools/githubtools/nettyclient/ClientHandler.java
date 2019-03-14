package com.githubtools.githubtools.nettyclient;

import com.githubtools.githubtools.nettyserver.Utils;
import com.githubtools.githubtools.protocol.Response;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        // ByteBuf byteBuf = (ByteBuf) msg;
        // System.out.println(Utils.getString(byteBuf));
        Response.CIMResProtocol msg1 = (Response.CIMResProtocol) msg;
        System.out.println(msg1);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("complete");
    }
}
