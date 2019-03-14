package com.githubtools.githubtools.nettyserver;

import com.githubtools.githubtools.protocol.Request;
import com.githubtools.githubtools.protocol.Response;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.HashSet;
import java.util.Set;

public class ServerHandler extends SimpleChannelInboundHandler {

    public static final Set<Channel> channelSet = new HashSet<>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        Request.CIMReqProtocol msg1 = (Request.CIMReqProtocol) msg;
        System.out.println(msg1.toString());


        // // ByteBuf byteBuf = (ByteBuf) msg;
        // // int i = byteBuf.readableBytes();
        // // System.out.println(Utils.getString(byteBuf));
        // // ByteBuf buffer = Unpooled.buffer();
        // // buffer.writeBytes(("abcde" ).getBytes());
        // // ctx.writeAndFlush(buffer);
        //
        // Response.CIMResProtocol world = Response.CIMResProtocol.newBuilder()
        //         .setType(9)
        //         .setResMsg("world")
        //         .setResponseId(908L)
        //         .build();
        // ctx.writeAndFlush(world);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("complete");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("active\n");
        Channel channel = ctx.channel();
        channelSet.add(channel);
        System.out.println(channel.getClass());
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("not active!");
    }
}
