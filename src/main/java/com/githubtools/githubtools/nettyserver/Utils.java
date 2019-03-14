package com.githubtools.githubtools.nettyserver;

import io.netty.buffer.ByteBuf;

public class Utils {
    public static String getString(ByteBuf msg) {
        int i = msg.readableBytes();
        byte[] bytes = new byte[i];
        msg.readBytes(bytes);
        return new String(bytes);
    }
}
