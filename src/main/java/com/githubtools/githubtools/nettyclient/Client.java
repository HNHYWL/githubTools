package com.githubtools.githubtools.nettyclient;

import com.githubtools.githubtools.protocol.Request;
import com.githubtools.githubtools.protocol.Response;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {

        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new ProtobufVarint32FrameDecoder())
                                .addLast(new ProtobufDecoder(Response.CIMResProtocol.getDefaultInstance()))
                                .addLast(new ProtobufVarint32LengthFieldPrepender())
                                .addLast(new ProtobufEncoder())
                                .addLast(new ClientHandler());
                    }
                })
        ;

        ChannelFuture future = bootstrap.connect("localhost", 8990).sync();

        if (future.isSuccess()) {
            System.out.println("启动 cim client 成功");
        }

        SocketChannel channel = (SocketChannel) future.channel();

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (true) {
            // TimeUnit.SECONDS.sleep(3);
            // ByteBuf buffer = Unpooled.buffer();
            // buffer.writeBytes(("abcde" + i++).getBytes());
            // ChannelFuture channelFuture = channel.writeAndFlush(buffer);
            String line = scanner.nextLine();
            Request.CIMReqProtocol hello = Request.CIMReqProtocol.newBuilder()
                    .setReqMsg(line)
                    .setType(1)
                    .setRequestId(29L)
                    .build();

            channel.writeAndFlush(hello);
        }
    }
}
