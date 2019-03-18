package com.githubtools.githubtools.signal;

import sun.misc.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.net.ServerSocket;
import java.nio.ByteBuffer;

@SuppressWarnings("restriction")
class TestSignal implements SignalHandler {

    public void handle(Signal arg0) {
        System.out.println(arg0.getName() + "is recevied.");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}


class App {
    @SuppressWarnings("restriction")
    public static void main(String[] args) {
        TestSignal handler = new TestSignal();
        Signal.handle(new Signal("TERM"), handler);
        Signal.handle(new


                Signal("INT"), handler);
        // Signal.handle(new Signal("USR1"), handler);
        Signal.handle(new Signal("USR2"), handler);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        for (; ; ) {
            System.out.println("do something");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class GetThreadID {
    public int[] qSort(int[] arr, int index1, int index2) {
        if (index1 < index2) {
            int tmp = arr[index1], low = index1, high = index2;

            while (low < high) {
                if (arr[high] > tmp) high--;
                else if (arr[low] <= tmp) low++;
                else {
                    int temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                    high--;
                }
            }

            arr[index1] = arr[low];
            arr[low] = tmp;

            qSort(arr, index1, low - 1);
            qSort(arr, low + 1, index2);
        }
        return arr;
    }

    public static native int get_tid();

    static {
        System.loadLibrary("GetThreadID");
    }

    public static void main(String[] args) {
        int tid = GetThreadID.get_tid();
        System.out.println("main TID=" + tid);

        new Thread() {
            @Override
            public void run() {
                int tid = GetThreadID.get_tid();
                System.out.println("TID=" + tid);
                while (true) {
                }
            }
        }.start();

        while (true) {
        }

    }
}


class Socket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8800);
        java.net.Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[3];
        int read;
        while ((read = inputStream.read(bytes)) != -1) {
            System.out.println(read);
            System.out.println(new String(bytes));
        }

    }
}