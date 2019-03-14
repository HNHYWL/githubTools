package com.githubtools.githubtools.pingpong.server;

import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NettySocketHolder {
    private static final Map<Long, NioSocketChannel> MAP = new ConcurrentHashMap<>();

    public static void put(long id, NioSocketChannel nioSocketChannel) {
        MAP.put(id, nioSocketChannel);
    }


    public static NioSocketChannel get(Long id) {
        return MAP.get(id);
    }

    public static Map<Long, NioSocketChannel> getMAP() {
        return MAP;
    }

    public static void remove(NioSocketChannel nioSocketChannel) {
        MAP.entrySet().stream().filter(entry -> entry.getValue() == nioSocketChannel)
                .forEach(entry -> MAP.remove(entry.getKey()));
    }
}
