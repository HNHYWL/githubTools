package com.githubtools.githubtools.pingpong.server;

public class Zi extends AbstractFu {
    @Override
    public void show() {
        System.out.println("show");
    }

    @Override
    public int getA() {
        return a;
    }

    private int a = 8;


    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.show();
        System.out.println(zi.getA());
        System.out.println(zi.getB());
    }
}
